package io.better.browser.config;

import io.better.core.authentication.SmsAuthenticationSecurityConfig;
import io.better.core.config.ValidateSecurityConfig;
import io.better.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * The type Browser security config.
 *
 * @author better
 * @date create in 2018/9/17 下午4:57
 */
@Configuration
@EnableWebSecurity
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthenticationSuccessHandler browserAuthenticationSuccessHandler;
    private final AuthenticationFailureHandler browserAuthenticationFailedHandler;
    private final SecurityProperties securityProperties;
    private final ValidateSecurityConfig validateSecurityConfig;
    private final SmsAuthenticationSecurityConfig smsAuthenticationSecurityConfig;

    @Autowired
    public BrowserSecurityConfig(AuthenticationSuccessHandler browserAuthenticationSuccessHandler,
                                 AuthenticationFailureHandler browserAuthenticationFailedHandler, SecurityProperties securityProperties,
                                 ValidateSecurityConfig validateSecurityConfig, SmsAuthenticationSecurityConfig smsAuthenticationSecurityConfig) {
        this.browserAuthenticationSuccessHandler = browserAuthenticationSuccessHandler;
        this.browserAuthenticationFailedHandler = browserAuthenticationFailedHandler;
        this.securityProperties = securityProperties;
        this.validateSecurityConfig = validateSecurityConfig;
        this.smsAuthenticationSecurityConfig = smsAuthenticationSecurityConfig;
    }

    /**
     * 浏览器的Security配置
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(final HttpSecurity http) throws Exception {


        http
            // 引入验证码的配置
            .apply(validateSecurityConfig)
                .and()
            // 引入短信登录的配置
            .apply(smsAuthenticationSecurityConfig)
                .and()
            .authorizeRequests()
                .antMatchers("/api/validate/code/**", securityProperties.getBrowser().getLoginPage())
                    .permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/browser/authentication/require").permitAll()
                .loginProcessingUrl("/login/form")
                .successHandler(browserAuthenticationSuccessHandler)
                .failureHandler(browserAuthenticationFailedHandler)
                .and()
            .logout()
                .logoutUrl(securityProperties.getBrowser().getLogoutUrl())
                .logoutSuccessUrl(securityProperties.getBrowser().getLogoutSuccessUrl())
                // 配置了登录成功处理器，logoutSuccessUrl将会被忽略
                .logoutSuccessHandler((request, response, authentication) -> {

                })
                .invalidateHttpSession(true)
                .deleteCookies()
                .and()
            .csrf().disable();
    }

    /**
     * Override this method to configure {@link WebSecurity}. For example, if you wish to
     * ignore certain requests.
     *
     * @param web
     */
    @Override
    public void configure(final WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/webjars/**", "/img/**", "/css/**", "/static/js/**");
    }

    /**
     * B crypt password encoder b crypt password encoder.
     *
     * @return the b crypt password encoder
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

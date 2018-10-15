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
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

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
    private final SessionInformationExpiredStrategy sessionInformationExpiredStrategy;
    private final InvalidSessionStrategy invalidSessionStrategy;
    private final LogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    public BrowserSecurityConfig(AuthenticationSuccessHandler browserAuthenticationSuccessHandler,
                                 AuthenticationFailureHandler browserAuthenticationFailedHandler, SecurityProperties securityProperties,
                                 ValidateSecurityConfig validateSecurityConfig, SmsAuthenticationSecurityConfig smsAuthenticationSecurityConfig, SessionInformationExpiredStrategy sessionInformationExpiredStrategy, InvalidSessionStrategy invalidSessionStrategy, LogoutSuccessHandler logoutSuccessHandler) {
        this.browserAuthenticationSuccessHandler = browserAuthenticationSuccessHandler;
        this.browserAuthenticationFailedHandler = browserAuthenticationFailedHandler;
        this.securityProperties = securityProperties;
        this.validateSecurityConfig = validateSecurityConfig;
        this.smsAuthenticationSecurityConfig = smsAuthenticationSecurityConfig;
        this.sessionInformationExpiredStrategy = sessionInformationExpiredStrategy;
        this.invalidSessionStrategy = invalidSessionStrategy;
        this.logoutSuccessHandler = logoutSuccessHandler;
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
            .formLogin()
                .loginPage("/browser/authentication/require").permitAll()
                .loginProcessingUrl("/login/form")
                .successHandler(browserAuthenticationSuccessHandler)
                .failureHandler(browserAuthenticationFailedHandler)
                .and()
            .sessionManagement()
                .invalidSessionStrategy(invalidSessionStrategy)
                .maximumSessions(securityProperties.getBrowser().getSessionProp().getMaximumSessions())
                .maxSessionsPreventsLogin(securityProperties.getBrowser().getSessionProp().getMaxSessionsPreventsLogin())
                .expiredSessionStrategy(sessionInformationExpiredStrategy)
                .and()
                .and()
            .logout()
                .logoutUrl(securityProperties.getBrowser().getLogoutUrl())
                // 配置了登录成功处理器，logoutSuccessUrl将会被忽略
                .logoutSuccessHandler(logoutSuccessHandler)
                .deleteCookies("JSESSIONID")
                .and()
            .authorizeRequests()
                .antMatchers("/api/validate/code/**", securityProperties.getBrowser().getLoginPage(),
                        securityProperties.getBrowser().getLogoutUrl(),
                        securityProperties.getBrowser().getSessionProp().getSessionInvalidUrl() + ".html",
                        securityProperties.getBrowser().getSessionProp().getSessionInvalidUrl() + ".json")
                .permitAll()
                .anyRequest().authenticated()
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
        web.ignoring().antMatchers("/webjars/**", "/img/**", "/css/**", "/js/**");
    }

    /**
     * B crypt password encoder b crypt password encoder.
     *
     * @return the b crypt password encoder
     */

}

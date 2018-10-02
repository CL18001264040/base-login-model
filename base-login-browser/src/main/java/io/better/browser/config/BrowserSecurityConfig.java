package io.better.browser.config;

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

    @Autowired
    public BrowserSecurityConfig(AuthenticationSuccessHandler browserAuthenticationSuccessHandler,
                                 AuthenticationFailureHandler browserAuthenticationFailedHandler, SecurityProperties securityProperties) {
        this.browserAuthenticationSuccessHandler = browserAuthenticationSuccessHandler;
        this.browserAuthenticationFailedHandler = browserAuthenticationFailedHandler;
        this.securityProperties = securityProperties;
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
                .formLogin()
                //设置自定义的登录页面
                .loginPage("/browser/authentication/require")
                //设置自定义的登录url
                .loginProcessingUrl("/login/base")
                .successHandler(browserAuthenticationSuccessHandler)
                .failureHandler(browserAuthenticationFailedHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/api/validate/code/**").permitAll()
                .antMatchers("/browser/authentication/require", securityProperties.getBrowser().getLoginPage()).permitAll()
                .anyRequest().authenticated()
                .and()
                .logout()
                .permitAll()
                .and()
                .csrf().disable();

        //http.addFilterBefore(ipAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
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

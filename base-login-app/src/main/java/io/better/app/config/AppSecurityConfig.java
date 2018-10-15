package io.better.app.config;

import io.better.core.authentication.SmsAuthenticationSecurityConfig;
import io.better.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * The type App security config.
 *
 * @author better
 * @date create in 2018/9/17 下午5:01
 */
@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    private final SecurityProperties securityProperties;
    private final SmsAuthenticationSecurityConfig smsAuthenticationSecurityConfig;
    @Autowired
    private AuthenticationSuccessHandler appAuthenticationSuccessHandler;
    @Autowired
    private AuthenticationFailureHandler appAuthenticationFailedHandler;

    public AppSecurityConfig(SecurityProperties securityProperties, SmsAuthenticationSecurityConfig smsAuthenticationSecurityConfig) {
        this.securityProperties = securityProperties;
        this.smsAuthenticationSecurityConfig = smsAuthenticationSecurityConfig;
    }

    /**
     * App的Security配置
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // 引入短信登录的配置
            .apply(smsAuthenticationSecurityConfig)
                .and()
                .formLogin()
            .loginPage("/app/authentication/require").permitAll()
                .loginProcessingUrl("/login/form")
                .successHandler(appAuthenticationSuccessHandler)
                .failureHandler(appAuthenticationFailedHandler)
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
}

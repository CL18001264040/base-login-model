package io.better.core.authentication;

import io.better.core.authentication.filter.SmsAuthenticationFilter;
import io.better.core.authentication.provider.SmsAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * The type Sms authentication security config.
 *
 * @author better create in 2018/10/2 20:37
 */
@Component
public class SmsAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private UserDetailsService userDetailsService;
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    private AuthenticationFailureHandler authenticationFailureHandler;

    /**
     * Instantiates a new Sms authentication security config.
     *
     * @param userDetailsService           the user details service
     * @param authenticationSuccessHandler the authentication success handler
     * @param authenticationFailureHandler the authentication failure handler
     */
    @Autowired
    public SmsAuthenticationSecurityConfig(UserDetailsService userDetailsService,
                                           AuthenticationSuccessHandler authenticationSuccessHandler,
                                           AuthenticationFailureHandler authenticationFailureHandler) {
        this.userDetailsService = userDetailsService;
        this.authenticationSuccessHandler = authenticationSuccessHandler;
        this.authenticationFailureHandler = authenticationFailureHandler;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        // 创建短信的filter
        SmsAuthenticationFilter smsAuthenticationFilter = new SmsAuthenticationFilter();
        // 创建短信验证码的provider
        SmsAuthenticationProvider smsAuthenticationProvider = new SmsAuthenticationProvider(userDetailsService);

        // 设置authenticationManager
        smsAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
        // 设置成功和失败的处理器
        smsAuthenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        smsAuthenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler);

        // 添加到配置中
        http.authenticationProvider(smsAuthenticationProvider)
                .addFilterAfter(smsAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}

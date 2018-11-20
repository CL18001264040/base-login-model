package io.better.core.authentication;

import io.better.core.authentication.filter.JwtAuthenticationFilter;
import io.better.core.authentication.filter.SmsAuthenticationFilter;
import io.better.core.authentication.provider.JwtAuthenticationProvider;
import io.better.core.authentication.provider.SmsAuthenticationProvider;
import io.better.rbac.servoce.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
public class JwtAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private UsersService usersService;
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    private AuthenticationFailureHandler authenticationFailureHandler;

    /**
     * Instantiates a new Sms authentication security config.
     *
     * @param usersService                 the users service
     * @param authenticationSuccessHandler the authentication success handler
     * @param authenticationFailureHandler the authentication failure handler
     */
    @Autowired
    public JwtAuthenticationSecurityConfig(UsersService usersService, AuthenticationSuccessHandler authenticationSuccessHandler,
                                           AuthenticationFailureHandler authenticationFailureHandler) {
        this.usersService = usersService;
        this.authenticationSuccessHandler = authenticationSuccessHandler;
        this.authenticationFailureHandler = authenticationFailureHandler;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        // 创建短信的filter
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter();
        // 设置authenticationManager
        jwtAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
        // 设置成功和失败的处理器
        jwtAuthenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        jwtAuthenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler);

        // 创建短信验证码的provider
        JwtAuthenticationProvider jwtAuthenticationProvider = new JwtAuthenticationProvider(usersService);

        // 添加到配置中
        http.authenticationProvider(jwtAuthenticationProvider)
                .addFilterAfter(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}

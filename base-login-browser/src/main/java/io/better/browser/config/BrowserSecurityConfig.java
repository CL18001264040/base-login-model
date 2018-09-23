package io.better.browser.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author better
 * @date create in 2018/9/17 下午4:57
 */
@Order(value = 100)
@Configuration
@EnableWebSecurity
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationSuccessHandler browserAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler browserAuthenticationFailedHandler;

    /**
     * 浏览器的Security配置
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
            /*配置登录*/
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            /*配置登出*/
            .logout()
                .permitAll();
    }


    /**
     * 配置内存中的用户信息-测试使用
     *
     * @param auth 认证管理构建
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("admin").password("123456").roles("USER");
    }
}

package io.better.core.config;

import io.better.core.validate.filter.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.stereotype.Component;

/**
 * @author better
 * @date create in 2018/10/10 下午4:07
 */
@Component
public class ValidateSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final ValidateCodeFilter validateCodeFilter;

    @Autowired
    public ValidateSecurityConfig(ValidateCodeFilter validateCodeFilter) {
        this.validateCodeFilter = validateCodeFilter;
    }

    /**
     * 配置校验的filter
     *
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {

        // 将验证吗过滤器添加到 抽象前置认证处理过滤器前
        http.addFilterBefore(validateCodeFilter, AbstractPreAuthenticatedProcessingFilter.class);
    }
}

package io.better.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * The type App security config.
 *
 * @author better
 * @date create in 2018/9/17 下午5:01
 */
@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * App的Security配置
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }
}

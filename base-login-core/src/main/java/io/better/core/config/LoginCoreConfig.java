package io.better.core.config;

import io.better.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 登录核心配置
 *
 * @author better
 * @date create in 2018/9/12 下午8:14
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class LoginCoreConfig {
}

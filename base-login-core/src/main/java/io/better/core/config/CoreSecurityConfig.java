package io.better.core.config;

import io.better.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author better
 * @date create in 2018/10/10 下午4:11
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class CoreSecurityConfig {
}

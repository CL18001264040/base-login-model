package io.better.core.config;

import io.better.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 属性的配置类
 *
 * @author better
 * @date create in 2018/9/13 下午4:08
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class PropertiesConfig {
}

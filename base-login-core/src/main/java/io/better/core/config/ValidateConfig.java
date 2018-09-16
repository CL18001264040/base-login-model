package io.better.core.config;

import io.better.core.properties.SecurityProperties;
import io.better.core.validate.generator.impl.DefaultImageCodeGenerator;
import io.better.core.validate.generator.impl.DefaultSmsCodeGenerator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 验证的配置类
 *
 * @author better
 * @date create in 2018/9/13 下午3:59
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class ValidateConfig {


}

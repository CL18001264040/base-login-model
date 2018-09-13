package io.better.core.config;

import io.better.core.properties.SecurityProperties;
import io.better.core.validate.generator.impl.StandardImageCodeGenerator;
import io.better.core.validate.generator.impl.StandardSmsCodeGenerator;
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

    /**
     * Sms code generator sms code generator.
     *
     * @return the sms code generator
     */
    @Bean
    @ConditionalOnMissingBean(value = StandardSmsCodeGenerator.class)
    public StandardSmsCodeGenerator smsCodeGenerator() {
        return new StandardSmsCodeGenerator();
    }

    /**
     * Image code generator image code generator.
     *
     * @return the image code generator
     */
    @Bean
    @ConditionalOnMissingBean(value = StandardImageCodeGenerator.class)
    public StandardImageCodeGenerator imageCodeGenerator() {
        return new StandardImageCodeGenerator();
    }
}

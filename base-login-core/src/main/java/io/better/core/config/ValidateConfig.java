package io.better.core.config;

import io.better.core.properties.SecurityProperties;
import io.better.core.validate.generator.impl.ImageCodeGenerator;
import io.better.core.validate.generator.impl.SmsCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 验证的配置类
 *
 * @author better
 * @date create in 2018/9/13 下午3:59
 */
@Configuration
public class ValidateConfig {

    private final SecurityProperties securityProperties;

    /**
     * Instantiates a new Validate config.
     *
     * @param securityProperties the security properties
     */
    @Autowired
    public ValidateConfig(final SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }


    /**
     * 如果容器没有imageCodeGenerator，则创建默认的生成器
     *
     * @return the image code generator
     */
    @Bean
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ImageCodeGenerator imageCodeGenerator() {

        return new ImageCodeGenerator(this.securityProperties);
    }

    /**
     * 如果容器没有smsCodeGenerator，则创建默认的生成器
     *
     * @return the sms code generator
     */
    @Bean
    @ConditionalOnMissingBean(name = "smsCodeGenerator")
    public SmsCodeGenerator smsCodeGenerator() {

        return new SmsCodeGenerator(this.securityProperties);
    }
}

package io.better.core.validate;

import io.better.core.properties.SecurityProperties;
import io.better.core.validate.img.ImageValidateCodeGenerator;
import io.better.core.validate.sms.SmsCodeSender;
import io.better.core.validate.sms.SmsValidateCodeGenerator;
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
public class ValidateCodeConfig {

    private final SecurityProperties securityProperties;

    /**
     * Instantiates a new Validate config.
     *
     * @param securityProperties the security properties
     */
    @Autowired
    public ValidateCodeConfig(final SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }


    /**
     * 如果容器没有imageCodeGenerator，则创建默认的生成器
     *
     * @return the image code generator
     */
    @Bean
    @ConditionalOnMissingBean
    public ImageValidateCodeGenerator imageCodeGenerator() {

        return new ImageValidateCodeGenerator(this.securityProperties);
    }

    /**
     * 如果容器没有smsCodeGenerator，则创建默认的生成器
     *
     * @return the sms code generator
     */
    @Bean
    @ConditionalOnMissingBean
    public SmsValidateCodeGenerator smsCodeGenerator() {

        return new SmsValidateCodeGenerator(this.securityProperties);
    }

    @Bean
    @ConditionalOnMissingBean
    public SmsCodeSender smsCodeSender() {
        return new SmsCodeSender.DefaultSmsCodeSender();
    }
}

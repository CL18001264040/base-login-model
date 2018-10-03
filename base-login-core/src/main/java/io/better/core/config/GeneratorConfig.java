package io.better.core.config;

import io.better.core.properties.SecurityProperties;
import io.better.core.validate.ValidateCodeGenerator;
import io.better.core.validate.img.ImageValidateCodeGenerator;
import io.better.core.validate.sms.SmsValidateCodeGenerator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author better create in 2018/9/13 下午9:53
 */
@Configuration
public class GeneratorConfig {

    private SecurityProperties securityProperties;

    /**
     * 如果没提供smsCodeGenerator组件，则使用默认的短信验证码生成器
     *
     * @return the sms code generator
     */
    @Bean
    @ConditionalOnMissingBean(name = "smsCodeGenerator")
    public ValidateCodeGenerator smsCodeGenerator() {
        return new SmsValidateCodeGenerator(this.securityProperties);
    }

    /**
     * Image code generator image code generator.
     *
     * @return the image code generator
     */
    @Bean
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerator imageCodeGenerator() {
        return new ImageValidateCodeGenerator(this.securityProperties);
    }
}

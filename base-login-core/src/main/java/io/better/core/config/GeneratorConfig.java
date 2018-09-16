package io.better.core.config;

import io.better.core.validate.generator.CodeGenerator;
import io.better.core.validate.generator.impl.DefaultImageCodeGenerator;
import io.better.core.validate.generator.impl.DefaultSmsCodeGenerator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author better create in 2018/9/13 下午9:53
 */
@Configuration
public class GeneratorConfig {

    /**
     * 如果没提供smsCodeGenerator组件，则使用默认的短信验证码生成器
     *
     * @return the sms code generator
     */
    @Bean
    @ConditionalOnMissingBean(name = "smsCodeGenerator")
    public CodeGenerator smsCodeGenerator() {
        return new DefaultSmsCodeGenerator();
    }

    /**
     * Image code generator image code generator.
     *
     * @return the image code generator
     */
    @Bean
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public CodeGenerator imageCodeGenerator() {
        return new DefaultImageCodeGenerator();
    }
}

package io.better.core.validate.generator.impl;

import io.better.core.properties.SecurityProperties;
import io.better.core.validate.generator.CodeGenerator;

import java.util.Arrays;

/**
 * 短信验证码生成器
 *
 * @author better
 * @date create in 2018/9/12 下午7:51
 */
public class SmsCodeGenerator implements CodeGenerator<String, String> {

    private final SecurityProperties securityProperties;

    /**
     * Instantiates a new Sms code generator.
     *
     * @param securityProperties the security properties
     */
    public SmsCodeGenerator(final SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }


    /**
     * 生成验证码方法，由子类实现自己的生成逻辑
     *
     * @param inParams 输入参数
     * @return
     */
    @Override
    public String generatorCode(final String... inParams) {
        String cellPhone = Arrays.stream(inParams).findFirst().orElse("");
        return null;
    }
}

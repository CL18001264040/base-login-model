package io.better.core.validate.generator.impl;

import io.better.core.properties.SecurityProperties;
import io.better.core.validate.generator.CodeGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * The type Image code generator.
 *
 * @author better
 * @date create in 2018/9/12 下午7:51
 */
@Slf4j
public class ImageCodeGenerator implements CodeGenerator<String, String> {

    private final SecurityProperties securityProperties;

    /**
     * Instantiates a new Image code generator.
     *
     * @param securityProperties the security properties
     */
    public ImageCodeGenerator(final SecurityProperties securityProperties) {
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
        final String randomStr = UUID.randomUUID().toString();
        String[] validateCodeArray = randomStr.substring(randomStr.indexOf("-") + 1, randomStr.lastIndexOf("-"))
                .toUpperCase().split("-");
        String validateCode = StringUtils.join(validateCodeArray);

        log.info("generate validate code is => {}", validateCode);
        return StringUtils.join(validateCodeArray, "-");
    }
}

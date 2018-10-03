package io.better.core.validate.sms;

import io.better.core.properties.SecurityProperties;
import io.better.core.validate.ValidateCode;
import io.better.core.validate.ValidateCodeGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 短信验证码生成器
 *
 * @author better
 * @date create in 2018/9/12 下午7:51
 */
public class SmsValidateCodeGenerator implements ValidateCodeGenerator {

    private final SecurityProperties securityProperties;

    /**
     * Instantiates a new Sms code generator.
     *
     * @param securityProperties the security properties
     */
    public SmsValidateCodeGenerator(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    /**
     * 生成验证码方法，由子类实现自己的生成逻辑
     *
     * @param request the request
     * @return validate code
     */
    @Override
    public ValidateCode generatorCode(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(securityProperties.getValidate().getSms().getLength());
        return new SmsCode(code, securityProperties.getValidate().getSms().getExpire());
    }
}

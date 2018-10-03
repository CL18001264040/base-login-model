package io.better.core.validate;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * code生成借口
 *
 * @author better
 * @date create in 2018/9/12 下午7:52
 */
public interface ValidateCodeGenerator {

    /**
     * 生成验证码方法，由子类实现自己的生成逻辑
     *
     * @param request the request
     * @return validate code
     */
    ValidateCode generatorCode(ServletWebRequest request);
}

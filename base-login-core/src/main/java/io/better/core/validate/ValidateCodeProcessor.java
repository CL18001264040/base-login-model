package io.better.core.validate;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 验证码处理器借口
 *
 * @param <T> the type parameter
 * @author better
 * @date create in 2018/9/12 下午7:46
 */
public interface ValidateCodeProcessor<T> {

    /**
     * The constant SESSION_KEY_PREFIX.
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    /**
     * 处理验证码请求
     *
     * @param request the request
     */
    void processor(ServletWebRequest request);

    /**
     * 生成验证码
     *
     * @param request the request
     * @return the t
     */
    T generate(ServletWebRequest request);

    /**
     * 保存验证码
     *
     * @param request      the request
     * @param validateCode the validate code
     */
    void save(ServletWebRequest request, T validateCode);

    /**
     * 发送验证码
     *
     * @param request      the request
     * @param validateCode the validate code
     */
    void send(ServletWebRequest request, T validateCode);

    /**
     * 校验验证码.
     *
     * @param request the request
     */
    void validate(ServletWebRequest request);
}

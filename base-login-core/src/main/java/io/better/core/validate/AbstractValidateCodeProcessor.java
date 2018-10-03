package io.better.core.validate;

import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionAttributeStore;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * The type Abstract validate code processor.
 *
 * @param <T> the type parameter
 * @author better create in 2018/10/3 11:18
 */
public abstract class AbstractValidateCodeProcessor<T extends ValidateCode> implements ValidateCodeProcessor<T> {

    private SessionAttributeStore sessionAttributeStore;
    private ValidateCodeBeanHolder validateCodeBeanHolder;

    /**
     * Instantiates a new Abstract validate code processor.
     *
     * @param validateCodeBeanHolder the validate code bean holder
     */
    protected AbstractValidateCodeProcessor(ValidateCodeBeanHolder validateCodeBeanHolder) {
        this.validateCodeBeanHolder = validateCodeBeanHolder;
        this.sessionAttributeStore = new DefaultSessionAttributeStore();
    }


    /**
     * 处理验证码请求
     *
     * @param request the request
     */
    @Override
    public void processor(ServletWebRequest request) {
        T code = generate(request);
        save(request, code);
        send(request, code);
    }

    /**
     * 生成验证码
     *
     * @param request the request
     * @return the t
     */
    @Override
    public T generate(ServletWebRequest request) {
        ValidateCodeGenerator validateCodeGenerator = validateCodeBeanHolder.getValidateCodeGenerator("");
        ValidateCode validateCode = validateCodeGenerator.generatorCode(request);
        return (T) validateCode;
    }

    /**
     * 保存验证码
     *
     * @param request      the request
     * @param validateCode the validate code
     */
    @Override
    public void save(ServletWebRequest request, T validateCode) {
        sessionAttributeStore.storeAttribute(request, "", validateCode);
    }

    /**
     * 发送验证码
     *
     * @param request      the request
     * @param validateCode the validate code
     */
    @Override
    public abstract void send(ServletWebRequest request, T validateCode);

    /**
     * 校验验证码.
     *
     * @param request the request
     */
    @Override
    public void validate(ServletWebRequest request) {

    }

    /**
     * Gets session key.
     *
     * @return the session key
     */
    protected String getSessionKey() {
        return null;
    }
}

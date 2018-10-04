package io.better.core.validate;

import io.better.core.validate.exception.ValidateCodeException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionAttributeStore;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Objects;

/**
 * The type Abstract validate code processor.
 *
 * @param <T> the type parameter
 * @author better create in 2018/10/3 11:18
 */
@Slf4j
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
    public void processor(ServletWebRequest request, String type) {
        T code = generate(request, type);
        save(request, code, type);
        send(request, code);
    }

    /**
     * 生成验证码
     *
     * @param request the request
     * @param type    the type
     * @return the t
     */
    @Override
    @SuppressWarnings("unchecked")
    public T generate(ServletWebRequest request, String type) {
        ValidateCodeGenerator validateCodeGenerator = validateCodeBeanHolder.getValidateCodeGenerator(type);
        return (T) validateCodeGenerator.generatorCode(request);
    }

    /**
     * 保存验证码
     *
     * @param request      the request
     * @param validateCode the validate code
     * @param type         the type
     */
    @Override
    public void save(ServletWebRequest request, T validateCode, String type) {
        sessionAttributeStore.storeAttribute(request, getSessionKey(type), validateCode);
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
     * @param type    the type
     */
    @Override
    @SuppressWarnings("unchecked")
    public void validate(ServletWebRequest request, String type) {
        // 根据type获取存储在session中的validateCode
        String sessionKey = getSessionKey(type);
        T validateCode = (T) sessionAttributeStore.retrieveAttribute(request, sessionKey);

        // 获取到request中的验证码
        ValidateCodeType validateCodeType = ValidateCodeType.valueOf(type.toUpperCase());
        String requestParam = validateCodeType.getRequestParam();

        String validateCodeParam = null;
        try {
            validateCodeParam = ServletRequestUtils.getStringParameter(request.getRequest(), requestParam);
        } catch (ServletRequestBindingException exception) {
            log.error("get validateCodeParam is error => {}", exception);
            throw new ValidateCodeException("get validaCodeParam is error");
        }

        // 验证码是否存在
        if (Objects.isNull(validateCodeParam)) {
            throw new ValidateCodeException(requestParam + "is not exists");
        }

        // 验证码是否为空
        if (StringUtils.isBlank(validateCodeParam)) {
            throw new ValidateCodeException(requestParam + "is not empty");
        }

        // 验证码是否过期
        if (validateCode.isExpire()) {
            sessionAttributeStore.retrieveAttribute(request, sessionKey);
            throw new ValidateCodeException(requestParam + "is expired");
        }

        // 验证码是否匹配
        if (!StringUtils.equals(validateCodeParam, validateCode.getCode())) {
            throw new ValidateCodeException(requestParam + "is not match");
        }
        // 删除掉session中存放的验证码
        sessionAttributeStore.retrieveAttribute(request, sessionKey);
    }

    /**
     * Gets session key.
     *
     * @param type the type
     * @return the session key
     */
    protected String getSessionKey(String type) {

        return SESSION_KEY_PREFIX + type.toUpperCase();
    }
}

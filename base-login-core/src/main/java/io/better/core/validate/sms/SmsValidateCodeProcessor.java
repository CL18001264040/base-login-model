package io.better.core.validate.sms;

import io.better.core.support.Constant;
import io.better.core.validate.AbstractValidateCodeProcessor;
import io.better.core.validate.ValidateCodeBeanHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 短信验证码处理器
 *
 * @author better
 * @date create in 2018/9/12 下午7:49
 */
@Component
public class SmsValidateCodeProcessor extends AbstractValidateCodeProcessor<SmsCode> {

    private SmsCodeSender smsCodeSender;

    /**
     * Instantiates a new Sms validate code processor.
     *
     * @param validateCodeBeanHolder the validate code bean holder
     * @param smsCodeSender          the sms code sender
     */
    @Autowired
    protected SmsValidateCodeProcessor(ValidateCodeBeanHolder validateCodeBeanHolder, SmsCodeSender smsCodeSender) {
        super(validateCodeBeanHolder);
        this.smsCodeSender = smsCodeSender;
    }

    /**
     * 发送验证码
     *
     * @param request      the request
     * @param validateCode the validate code
     */
    @Override
    public void send(ServletWebRequest request, SmsCode validateCode) {
        String cellPhone = request.getParameter(Constant.CELL_PHONE_REQ_PARAMETER.getContent());
        smsCodeSender.sendSmsCode(cellPhone, validateCode.getCode());
    }
}

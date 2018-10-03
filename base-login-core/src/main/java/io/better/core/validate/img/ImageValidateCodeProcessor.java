package io.better.core.validate.img;

import io.better.core.validate.AbstractValidateCodeProcessor;
import io.better.core.validate.ValidateCodeBeanHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 图片验证码处理器
 *
 * @author better
 * @date create in 2018/9/12 下午7:49
 */
@Component
public class ImageValidateCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {


    @Autowired
    protected ImageValidateCodeProcessor(ValidateCodeBeanHolder validateCodeBeanHolder) {
        super(validateCodeBeanHolder);
    }

    /**
     * 发送验证码
     *
     * @param request      the request
     * @param validateCode the validate code
     */
    @Override
    public void send(ServletWebRequest request, ImageCode validateCode) {

    }
}

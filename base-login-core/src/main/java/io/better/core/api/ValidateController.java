package io.better.core.api;

import io.better.core.validate.ValidateCodeBeanHolder;
import io.better.core.validate.ValidateCodeProcessor;
import io.better.core.validate.ValidateCodeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The type Validate controller.
 *
 * @author better
 * @date create in 2018/9/29 下午3:28
 */
@RestController
@RequestMapping(value = "/api/validate")
public class ValidateController {

    /**
     * 图片验证码的session key
     */
    public static final String IMG_CODE_SESSION_KEY = "IMG_CODE_SESSION_KEY";
    /**
     * The constant SMS_CODE_SESSION_KEY.
     */
    public static final String SMS_CODE_SESSION_KEY = "SMS_CODE_SESSION_KEY";

    private ValidateCodeBeanHolder validateCodeBeanHolder;

    @Autowired
    public ValidateController(ValidateCodeBeanHolder validateCodeBeanHolder) {
        this.validateCodeBeanHolder = validateCodeBeanHolder;
    }


    /**
     * Img code string.
     *
     * @param type     the type , see {@link ValidateCodeType}
     * @param request  the request
     * @param response the response
     */
    @GetMapping(value = "/code/{type}")
    public void code(@PathVariable("type") String type, HttpServletRequest request, HttpServletResponse response) {

        ValidateCodeType validateCodeType = ValidateCodeType.valueOf(type);
        String validateType = validateCodeType.getType();

        ValidateCodeProcessor validateCodeProcessor = validateCodeBeanHolder.getValidateCodeProcessor(validateType);
        validateCodeProcessor.processor(new ServletWebRequest(request, response), validateType);
    }
}

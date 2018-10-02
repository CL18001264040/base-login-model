package io.better.core.api;

import io.better.core.validate.img.ImageCodeGenerator;
import io.better.core.validate.sms.SmsCodeGenerator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionAttributeStore;
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
    public static final String SMS_CODE_SESSION_KEY = "SMS_CODE_SESSION_KEY";

    private final ImageCodeGenerator imageCodeGenerator;
    private final SmsCodeGenerator smsCodeGenerator;
    private SessionAttributeStore sessionAttributeStores;

    /**
     * Instantiates a new Validate controller.
     *
     * @param imageCodeGenerator the image code generator
     * @param smsCodeGenerator   the sms code generator
     */
    @Autowired
    public ValidateController(final ImageCodeGenerator imageCodeGenerator, final SmsCodeGenerator smsCodeGenerator) {
        this.imageCodeGenerator = imageCodeGenerator;
        this.smsCodeGenerator = smsCodeGenerator;
        this.sessionAttributeStores = new DefaultSessionAttributeStore();
    }

    /**
     * Img code string.
     *
     * @return the string
     */
    @GetMapping(value = "/code/img")
    public String imgCode(HttpServletRequest request, HttpServletResponse response) {

        String validate = this.imageCodeGenerator.generatorCode();
        sessionAttributeStores.storeAttribute(new ServletWebRequest(request), IMG_CODE_SESSION_KEY,
                StringUtils.join(StringUtils.split(validate, "-")));
        return validate;
    }

    /**
     * Sms code string.
     *
     * @return the string
     */
    @GetMapping(value = "/code/sms")
    public String smsCode(@RequestParam("cellPhone") final String cellPhone) {

        return this.smsCodeGenerator.generatorCode(cellPhone);
    }
}

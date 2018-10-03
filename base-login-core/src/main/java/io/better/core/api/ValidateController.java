package io.better.core.api;

import io.better.core.validate.ValidateCode;
import io.better.core.validate.img.ImageValidateCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    /**
     * The constant SMS_CODE_SESSION_KEY.
     */
    public static final String SMS_CODE_SESSION_KEY = "SMS_CODE_SESSION_KEY";

    private final ImageValidateCodeGenerator imageCodeGenerator;
    private SessionAttributeStore sessionAttributeStores;

    /**
     * Instantiates a new Validate controller.
     *
     * @param imageCodeGenerator the image code generator
     */
    @Autowired
    public ValidateController(final ImageValidateCodeGenerator imageCodeGenerator) {
        this.imageCodeGenerator = imageCodeGenerator;
        this.sessionAttributeStores = new DefaultSessionAttributeStore();
    }

    /**
     * Img code string.
     *
     * @param type     the type
     * @param request  the request
     * @param response the response
     */
    @GetMapping(value = "/code/{type}")
    public void imgCode(@PathVariable String type, HttpServletRequest request, HttpServletResponse response) {

        ValidateCode validateCode = this.imageCodeGenerator.generatorCode(new ServletWebRequest(request, response));
    }
}

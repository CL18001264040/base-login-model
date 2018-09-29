package io.better.core.api;

import io.better.core.validate.generator.impl.ImageCodeGenerator;
import io.better.core.validate.generator.impl.SmsCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Validate controller.
 *
 * @author better
 * @date create in 2018/9/29 下午3:28
 */
@RestController
@RequestMapping(value = "/api/validate")
public class ValidateController {

    private final ImageCodeGenerator imageCodeGenerator;
    private final SmsCodeGenerator smsCodeGenerator;


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
    }

    /**
     * Img code string.
     *
     * @return the string
     */
    @GetMapping(value = "/code/img")
    public String imgCode() {

        return this.imageCodeGenerator.generatorCode();
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

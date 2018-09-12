package io.better.core.api;

import io.better.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author better
 * @date create in 2018/9/12 下午7:44
 */
@RestController
@RequestMapping(value = "/api/v1")
public class LoginController {

    @Autowired
    private SecurityProperties securityProperties;

    @GetMapping(value = "/properties")
    public void print() {

        System.out.println(securityProperties.getSmsProp());
        System.out.println(securityProperties.getImageProp());
    }
}

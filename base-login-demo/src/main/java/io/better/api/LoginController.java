package io.better.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author better
 * @date create in 2018/9/25 下午8:02
 */
@RestController
public class LoginController {

    @GetMapping(value = {"/index", "/", "/home"})
    public ModelAndView login() {

        return new ModelAndView("login");
    }

}

package io.better.api;

import io.better.rbac.model.dto.UsersDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author better
 * @date create in 2018/9/25 下午8:02
 */
@RestController
@Slf4j
public class LoginController {

    @GetMapping(value = "/user/{userId}")
    public UsersDto getUser(@PathVariable String userId) {
        log.info("userId => {}", userId);
        return new UsersDto("admin", "12312");
    }

    @GetMapping(value = "/me")
    public Object getMe(Authentication authentication) {

        return authentication;
    }
}

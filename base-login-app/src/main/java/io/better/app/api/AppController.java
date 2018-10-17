package io.better.app.api;

import io.better.core.properties.SecurityProperties;
import io.better.core.support.SimpleResponse;
import io.better.core.support.SuffixEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * The type App controller.
 *
 * @author better
 * @date create in 2018/9/17 下午5:04
 */
@RestController
@RequestMapping(value = "/app")
public class AppController {

    private final SecurityProperties securityProperties;
    private final RequestCache requestCache;
    private final RedirectStrategy redirectStrategy;

    @Autowired
    public AppController(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
        this.requestCache = new HttpSessionRequestCache();
        this.redirectStrategy = new DefaultRedirectStrategy();
    }


    @RequestMapping(value = "/authentication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public SimpleResponse<String> authentication(HttpServletRequest request, HttpServletResponse response) throws IOException {

        SavedRequest savedRequest = requestCache.getRequest(request, response);

        if (Objects.nonNull(savedRequest)) {
            String redirectUrl = savedRequest.getRedirectUrl();

            if (StringUtils.endsWithIgnoreCase(redirectUrl, SuffixEnum.HTML.getSuffix())) {
                redirectStrategy.sendRedirect(request, response, securityProperties.getBrowser().getLoginPage());
            }
        }
        return SimpleResponse.response("Requested resources, insufficient permissions, please go to the login page.");
    }
}

package io.better.browser.handler;

import io.better.core.properties.SecurityProperties;
import io.better.core.support.LoginType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Browser authentication failed handler.
 *
 * @author better create in 2018/9/23 10:29
 */
@Component
public class BrowserAuthenticationFailedHandler extends SimpleUrlAuthenticationFailureHandler {

    private final SecurityProperties securityProperties;

    @Autowired
    public BrowserAuthenticationFailedHandler(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }


    /**
     * Called when an authentication attempt fails.
     *
     * @param request   the request during which the authentication attempt occurred.
     * @param response  the response.
     * @param exception the exception which was thrown to reject the authentication
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {

        if (LoginType.isJson(securityProperties.getBrowser())) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(exception.getMessage());
        } else {
            super.onAuthenticationFailure(request, response, exception);
        }
    }
}

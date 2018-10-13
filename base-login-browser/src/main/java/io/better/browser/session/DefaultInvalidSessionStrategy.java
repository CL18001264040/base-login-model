package io.better.browser.session;

import org.springframework.security.web.session.InvalidSessionStrategy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author better
 * @date create in 2018/10/12 下午5:34
 */
public class DefaultInvalidSessionStrategy extends AbstractSessionStrategy implements InvalidSessionStrategy  {

    public DefaultInvalidSessionStrategy(String sessionInvalidUrl) {
        super(sessionInvalidUrl);
    }

    @Override
    public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        sessionInvalid(request,response);
    }

    @Override
    protected Boolean isCurrent() {
        return Boolean.TRUE;
    }
}

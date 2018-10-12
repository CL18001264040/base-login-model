package io.better.browser.session;

import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author better
 * @date create in 2018/10/12 下午5:44
 */
public class DefaultExpiredSessionStrategy extends AbstractSessionStrategy implements SessionInformationExpiredStrategy {

    public DefaultExpiredSessionStrategy(String sessionInvalidUrl) {
        super(sessionInvalidUrl);
    }

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {

    }
}

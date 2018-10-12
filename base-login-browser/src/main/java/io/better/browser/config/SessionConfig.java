package io.better.browser.config;

import io.better.browser.session.DefaultExpiredSessionStrategy;
import io.better.browser.session.DefaultInvalidSessionStrategy;
import io.better.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

/**
 * The type Session config.
 *
 * @author better
 * @date create in 2018/10/12 下午5:46
 */
@Configuration
public class SessionConfig {

    private final SecurityProperties securityProperties;

    @Autowired
    public SessionConfig(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    /**
     * Invalid session strategy invalid session strategy.
     *
     * @return the invalid session strategy
     */
    @Bean
    @ConditionalOnMissingBean(InvalidSessionStrategy.class)
    public InvalidSessionStrategy invalidSessionStrategy() {
        return new DefaultInvalidSessionStrategy(securityProperties.getBrowser().getSessionProp().getSessionInvalidUrl());
    }

    /**
     * Session information expired strategy session information expired strategy.
     *
     * @return the session information expired strategy
     */
    @Bean
    @ConditionalOnMissingBean(SessionInformationExpiredStrategy.class)
    public SessionInformationExpiredStrategy sessionInformationExpiredStrategy() {
        return new DefaultExpiredSessionStrategy(securityProperties.getBrowser().getSessionProp().getSessionInvalidUrl());
    }
}

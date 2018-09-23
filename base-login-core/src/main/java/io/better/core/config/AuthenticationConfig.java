package io.better.core.config;

import io.better.core.authentication.filter.IpAuthenticationFilter;
import io.better.core.authentication.provider.IpAuthenticationProvider;
import io.better.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Authentication config.
 *
 * @author better
 * @date create in 2018/9/19 下午4:37
 */
@Configuration
public class AuthenticationConfig {

    @Autowired
    private SecurityProperties securityProperties;


    /**
     * Ip authentication filter ip authentication filter.
     *
     * @return the ip authentication filter
     */
    @Bean
    @ConditionalOnMissingBean(name = "ipAuthenticationFilter")
    public IpAuthenticationFilter ipAuthenticationFilter() {
        return new IpAuthenticationFilter(securityProperties);
    }

    /**
     * Ip authentication provider ip authentication provider.
     *
     * @return the ip authentication provider
     */
    @Bean
    @ConditionalOnMissingBean(name = "ipAuthenticationProvider")
    public IpAuthenticationProvider ipAuthenticationProvider() {
        return new IpAuthenticationProvider();
    }
}

package io.better.core.social.qq.connection;

import io.better.core.social.qq.api.QQApi;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.oauth2.OAuth2ServiceProvider;

/**
 * @author better create in 2018/10/7 19:17
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQApi> {
    /**
     *
     *
     */
    public QQConnectionFactory(String providerId, OAuth2ServiceProvider<QQApi> serviceProvider, ApiAdapter<QQApi> apiAdapter) {
        super(providerId, serviceProvider, apiAdapter);
    }
}

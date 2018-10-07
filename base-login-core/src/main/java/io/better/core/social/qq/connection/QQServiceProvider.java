package io.better.core.social.qq.connection;

import io.better.core.social.qq.api.QQApi;
import io.better.core.social.qq.api.QQApiImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Operations;

/**
 * @author better create in 2018/10/7 19:20
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQApi> {

    private String appId;


    /**
     * 初始化
     */
    public QQServiceProvider(OAuth2Operations oauth2Operations) {
        super(oauth2Operations);
    }

    @Override
    public QQApi getApi(String accessToken) {
        return new QQApiImpl(accessToken, appId);
    }
}

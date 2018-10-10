package io.better.core.social.qq.connection;

import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.MultiValueMap;

/**
 * The type Qqo auth 2 template.
 *
 * @author better create in 2018/10/7 19:21
 */
public class QQOAuth2Template extends OAuth2Template {

    /**
     * 构造器
     *
     * @param clientId       the client id
     * @param clientSecret   the client secret
     * @param authorizeUrl   the authorize url
     * @param accessTokenUrl the access token url
     */
    public QQOAuth2Template(String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl) {
        super(clientId, clientSecret, authorizeUrl, accessTokenUrl);
    }


    /**
     * 重写获取accessGrant方法
     */
    @Override
    protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {
        return super.postForAccessGrant(accessTokenUrl, parameters);
    }
}

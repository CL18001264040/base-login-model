package io.better.core.social.wechat.connect;

import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.MultiValueMap;

/**
 * The type We chat o auth 2 template.
 *
 * @author better
 * @date create in 2018/10/11 上午10:12
 */
public class WeChatOAuth2Template extends OAuth2Template {
    /**
     * Instantiates a new We chat o auth 2 template.
     *
     * @param clientId       the client id
     * @param clientSecret   the client secret
     * @param authorizeUrl   the authorize url
     * @param accessTokenUrl the access token url
     */
    public WeChatOAuth2Template(String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl) {
        super(clientId, clientSecret, authorizeUrl, accessTokenUrl);
    }

    /**
     * 重写父类的方法
     *
     * @param authorizationCode
     * @param redirectUri
     * @param additionalParameters
     * @return
     */
    @Override
    public AccessGrant exchangeForAccess(String authorizationCode, String redirectUri, MultiValueMap<String, String> additionalParameters) {
        return super.exchangeForAccess(authorizationCode, redirectUri, additionalParameters);
    }
}

package io.better.core.social.qq.connection;

import org.springframework.social.oauth2.OAuth2Template;

/**
 * @author better create in 2018/10/7 19:21
 */
public class QQOAuth2Template extends OAuth2Template {

    /**
     * Constructs an OAuth2Template for a given set of client credentials.
     * Assumes that the authorization URL is the same as the authentication URL.
     *
     * @param clientId       the client ID
     * @param clientSecret   the client secret
     * @param authorizeUrl   the base URL to redirect to when doing authorization code or implicit grant authorization
     * @param accessTokenUrl the URL at which an authorization code, refresh token, or user credentials may be exchanged for an access token.
     */
    public QQOAuth2Template(String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl) {
        super(clientId, clientSecret, authorizeUrl, accessTokenUrl);
    }
}

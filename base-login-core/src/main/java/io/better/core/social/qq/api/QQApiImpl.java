package io.better.core.social.qq.api;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

/**
 * The type Qq api.
 *
 * @author better create in 2018/10/7 18:59
 */
public class QQApiImpl extends AbstractOAuth2ApiBinding implements QQApi {

    /**
     * QQ获取用户信息的Url
     */
    private static final String GET_USER_INFO_URL = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";

    /**
     * 获取QQ凭证的Url
     */
    private static final String GET_ACCESS_TOKEN_URL = "https://graph.qq.com/oauth2.0/me?access_token=%s";

    /**
     * 应用ID
     */
    private String appId;

    /**
     * 用户标识
     */
    private String openId;

    /**
     * 初始化QQApiImpl,多实例。
     *
     * @param accessToken the access token
     * @param appId       the app id
     */
    public QQApiImpl(String accessToken, String appId) {
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
        this.appId = appId;
        String getAccessTokenUrl = String.format(GET_ACCESS_TOKEN_URL, accessToken);
        String accessTokenResult = getRestTemplate().getForObject(getAccessTokenUrl, String.class);
        // 截取openId
        this.openId = StringUtils.substringBetween(accessTokenResult, "\"openid\":\"", "\"}");

    }

    /**
     * 获取QQ用户信息
     *
     * @return the qq user info
     */
    @Override
    public QQUserInfo getQQUserInfo() {
        String getUserInfoUrl = String.format(GET_USER_INFO_URL, appId, openId);
        String userInfoResult = getRestTemplate().getForObject(getUserInfoUrl, String.class);

        QQUserInfo userInfo = JSON.parseObject(userInfoResult, QQUserInfo.class);
        userInfo.setOpenId(openId);
        return userInfo;
    }
}

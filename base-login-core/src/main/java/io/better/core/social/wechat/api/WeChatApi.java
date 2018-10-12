package io.better.core.social.wechat.api;

/**
 * The interface We chat api.
 *
 * @author better
 * @date create in 2018/10/11 上午10:08
 */
public interface WeChatApi {

    /**
     * 获取微信用户信息
     *
     * @return the we chat user info
     */
    WeChatUserInfo getWeChatUserInfo();
}

package io.better.core.social.wechat.connect;

import io.better.core.social.wechat.api.WeChatApi;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * The type We chat adapter.
 *
 * @author better
 * @date create in 2018/10/11 上午10:11
 */
public class WeChatAdapter implements ApiAdapter<WeChatApi> {

    /**
     * 测试是否可用
     *
     * @param api the API binding
     * @return true if the API is functional, false if not
     */
    @Override
    public boolean test(WeChatApi api) {
        return false;
    }

    /**
     * 设置连接信息
     *
     * @param api    the API binding
     * @param values the connection values to set
     */
    @Override
    public void setConnectionValues(WeChatApi api, ConnectionValues values) {

    }

    /**
     * 抓取用户profile
     *
     * @param api the API binding
     * @return the service provider user profile
     */
    @Override
    public UserProfile fetchUserProfile(WeChatApi api) {
        return null;
    }

    /**
     * 更新状态
     *
     * @param api     the API binding
     * @param message the status message
     */
    @Override
    public void updateStatus(WeChatApi api, String message) {

    }
}

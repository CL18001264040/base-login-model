package io.better.core.social.qq.connect;

import io.better.core.social.qq.api.QQApi;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * The type Qq adapter.
 *
 * @author better create in 2018/10/7 19:15
 */
public class QQAdapter implements ApiAdapter<QQApi> {

    /**
     * 测试Api是否可用
     */
    @Override
    public boolean test(QQApi api) {
        return false;
    }

    /**
     * 设置连接信息
     */
    @Override
    public void setConnectionValues(QQApi api, ConnectionValues values) {

    }

    /**
     * 设置用户主页
     */
    @Override
    public UserProfile fetchUserProfile(QQApi api) {
        return null;
    }

    /**
     * 更新状态
     */
    @Override
    public void updateStatus(QQApi api, String message) {

    }
}

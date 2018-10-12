package io.better.core.social.wechat.connect;

import io.better.core.social.wechat.api.WeChatApi;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.oauth2.OAuth2ServiceProvider;

/**
 * The type We chat connection factory.
 *
 * @author better
 * @date create in 2018/10/11 上午10:11
 */
public class WeChatConnectionFactory extends OAuth2ConnectionFactory<WeChatApi> {

    /**
     * 创建微信连接工厂
     *
     * @param providerId      the provider id
     * @param serviceProvider the service provider
     * @param apiAdapter      the api adapter
     */
    public WeChatConnectionFactory(String providerId, OAuth2ServiceProvider<WeChatApi> serviceProvider, ApiAdapter<WeChatApi> apiAdapter) {
        super(providerId, serviceProvider, apiAdapter);
    }
}

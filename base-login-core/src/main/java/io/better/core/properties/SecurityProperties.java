package io.better.core.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * security 属性
 *
 * @author better
 * @date create in 2018/9/12 下午7:59
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "better.security")
public class SecurityProperties {

    /**
     * 浏览器相关配置
     */
    private BrowserProperties browser = new BrowserProperties();

    /**
     * 验证码相关配置
     */
    private ValidateProperties validate = new ValidateProperties();

    /**
     * 第三方登录配置
     */
    private SocialProperties social = new SocialProperties();

    /**
     * OAuth2相关配置
     */
    private Oauth2Properties oAuth2 = new Oauth2Properties();
}

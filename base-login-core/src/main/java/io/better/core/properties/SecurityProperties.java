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
@ConfigurationProperties(prefix = "base-login-security")
public class SecurityProperties {

    /**
     * 图片相关属性
     */
    private ImageCodeProperties imageProp = new ImageCodeProperties();

    /**
     * 短信相关属性
     */
    private SmsCodeProperties smsProp = new SmsCodeProperties();

    /**
     * 认证相关的属性
     */
    private AuthenticationProperties authenticationProp =  new AuthenticationProperties();
}

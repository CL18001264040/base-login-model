package io.better.core.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * security 属性
 *
 * @author better
 * @date create in 2018/9/12 下午7:59
 */
@ConfigurationProperties(prefix = "base-login.security")
public class SecurityProperties {

    /**
     * 图片相关属性
     */
    @Setter
    @Getter
    public ImageCodeProperties imageProp = new ImageCodeProperties();

    /**
     * 短信相关属性
     */
    @Setter
    @Getter
    public SmsCodeProperties smsProp = new SmsCodeProperties();
}

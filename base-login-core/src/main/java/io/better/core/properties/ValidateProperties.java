package io.better.core.properties;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The type Validate properties.
 *
 * @author better create in 2018/10/1 09:59
 */
@Data
public class ValidateProperties {

    /**
     * 图片属性
     */
    private ImageCodeProperties img = new ImageCodeProperties();

    /**
     * 短信属性
     */
    private SmsCodeProperties sms = new SmsCodeProperties();

    /**
     * 图片验证码相关的属性
     */
    @Data
    @EqualsAndHashCode(callSuper = true)
    public class ImageCodeProperties extends SmsCodeProperties {

        /**
         * 图片验证码的高
         */
        private Integer height;

        /**
         * 图片验证码的宽
         */
        private Integer width;
    }

    /**
     * 短信验证码相关的属性
     */
    @Data
    public class SmsCodeProperties {

        /**
         * 短信验证码长度
         */
        private Integer length = 6;

        /**
         * 短信验证码的拦截的url
         */
        private String urls;

        /**
         * 短信验证码的过期时间
         */
        private Integer expire = 60;
    }
}

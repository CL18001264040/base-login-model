package io.better.core.support;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Constant.
 *
 * @author better create in 2018/10/2 21:01
 */
@Getter
@AllArgsConstructor
public enum Constant {

    /**
     * 图片验证码Session key
     */
    IMAGE_CODE_SESSION_KEY("IMAGE_CODE_SESSION_KEY"),

    /**
     * 短信验证码Session key
     */
    SMS_CODE_SESSION_KEY("SMS_CODE_SESSION_KEY"),

    /**
     * 短信验证码请求参数
     */
    SMS_CODE_REQ_PARAMETER("smsValidateCode"),

    /**
     * 图片验证码请求参数
     */
    IMG_CODE_REQ_PARAMETER("imgValidateCode"),

    /**
     * 手机号请求参数
     */
    CELL_PHONE_REQ_PARAMETER("cellPhone"),

    /**
     * Post请求
     */
    POST("Post"),

    /**
     * Get请求
     */
    GET("Get");

    /**
     * 内容
     */
    private String content;
}

package io.better.core.validate;

import io.better.core.support.Constant;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Validate code type.
 *
 * @author better create in 2018/10/4 10:22
 */
@Getter
@AllArgsConstructor
public enum ValidateCodeType {

    /**
     * 图片验证码类型
     */
    IMAGE("image") {
        @Override
        public String getRequestParam() {
            return Constant.IMG_CODE_REQ_PARAMETER.getContent();
        }
    },

    /**
     * 短信验证码类型
     */
    SMS("sms") {
        @Override
        public String getRequestParam() {
            return Constant.SMS_CODE_REQ_PARAMETER.getContent();
        }
    };

    private String type;

    /**
     * Gets request param.
     *
     * @return the request param
     */
    public abstract String getRequestParam();
}

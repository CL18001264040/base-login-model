package io.better.core.properties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 短信验证码相关的属性
 *
 * @author better
 * @date create in 2018/9/12 下午8:02
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SmsCodeProperties {

    /**
     * 短信验证码的长度
     */
    private Integer length;

    /**
     * 过期时间
     */
    private Integer expireTime = 60;
}

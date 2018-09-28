package io.better.core.social.qq.token;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * The type Qq token.
 *
 * @author better
 * @date create in 2018/9/28 下午5:46
 */
@Setter
@Getter
@ToString
public class QqToken implements Serializable {

    /**
     * 访问凭证
     */
    private String accessToken;

    /**
     * 失效时间
     */
    private Integer expiresIn;

    /**
     * 刷新token
     */
    private String refreshToken;
}

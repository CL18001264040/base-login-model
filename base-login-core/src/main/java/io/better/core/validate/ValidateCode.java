package io.better.core.validate;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * The type Validate code.
 *
 * @author better create in 2018/10/2 17:43
 */
@Data
public class ValidateCode implements Serializable {

    private static final long serialVersionUID = -5555060334255195552L;

    /**
     * 短信验证码
     */
    private String code;

    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

    /**
     * Instantiates a new Validate code.
     *
     * @param code       the code
     * @param expireTime the expire time
     */
    public ValidateCode(String code, Integer expireTime) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireTime);
    }

    /**
     * Instantiates a new Validate code.
     *
     * @param code       the code
     * @param expireTime the expire time
     */
    public ValidateCode(String code, LocalDateTime expireTime) {
        this.code = code;
        this.expireTime = expireTime;
    }

    /**
     * Is expire boolean.
     *
     * @return the boolean
     */
    public Boolean isExpire() {
        return LocalDateTime.now().isAfter(expireTime);
    }
}

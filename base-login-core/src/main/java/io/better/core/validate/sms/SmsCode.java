package io.better.core.validate.sms;

import io.better.core.validate.ValidateCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * The type Sms code.
 *
 * @author better create in 2018/10/2 10:21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SmsCode extends ValidateCode {

    /**
     * Instantiates a new Sms code.
     *
     * @param code       the code
     * @param expireTime the expire time
     */
    public SmsCode(String code, Long expireTime) {
        super(code, expireTime);
    }

    /**
     * Instantiates a new Sms code.
     *
     * @param code       the code
     * @param expireTime the expire time
     */
    public SmsCode(String code, LocalDateTime expireTime) {
        super(code, expireTime);
    }
}
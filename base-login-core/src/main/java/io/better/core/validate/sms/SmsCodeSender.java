package io.better.core.validate.sms;

import lombok.extern.slf4j.Slf4j;

/**
 * The interface Sms code sender.
 *
 * @author better create in 2018/10/3 12:37
 */
public interface SmsCodeSender {

    /**
     * Send sms code.
     *
     * @param cellPhone the cell phone
     * @param code      the code
     */
    void sendSmsCode(String cellPhone, String code);

    /**
     * 默认的短信验证码发送器
     */
    @Slf4j
    class DefaultSmsCodeSender implements SmsCodeSender {

        /**
         * Send sms code.
         *
         * @param cellPhone the cell phone
         * @param code      the code
         */
        @Override
        public void sendSmsCode(String cellPhone, String code) {

            log.info("send sms code to cellPhone => {} and code => {}", cellPhone, code);
        }
    }
}

package io.better.core.validate;

import org.springframework.stereotype.Component;

/**
 * 短信验证码生成器
 *
 * @author better
 * @date create in 2018/9/12 下午7:51
 */
@Component
public class SmsCodeGenerator extends AbstractValidCodeGenerator {

    /**
     * 生成验证码方法，由子类实现自己的生成逻辑
     *
     * @return 生成结果
     */
    @Override
    String generatorValidCode() {
        return null;
    }
}

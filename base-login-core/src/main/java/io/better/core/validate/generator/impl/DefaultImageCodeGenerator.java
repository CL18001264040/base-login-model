package io.better.core.validate.generator.impl;

import io.better.core.validate.generator.AbstractValidCodeGenerator;
import org.springframework.stereotype.Component;

/**
 * @author better
 * @date create in 2018/9/12 下午7:51
 */
@Component
public class DefaultImageCodeGenerator extends AbstractValidCodeGenerator {

    /**
     * 生成验证码方法，由子类实现自己的生成逻辑
     *
     * @return 生成结果
     */
    @Override
    protected String generatorValidCode() {
        return null;
    }
}
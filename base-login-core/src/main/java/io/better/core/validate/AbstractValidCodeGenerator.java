package io.better.core.validate;

/**
 * 抽象的验证码生成器
 *
 * @author better
 * @date create in 2018/9/12 下午7:52
 */
public abstract class AbstractValidCodeGenerator implements CodeGenerator {

    /**
     * 生成验证码方法，由子类实现自己的生成逻辑
     *
     * @return 生成结果
     */
    abstract String generatorValidCode();
}

package io.better.core.validate.generator;

/**
 * code生成借口
 *
 * @param <In>  the type parameter
 * @param <Out> the type parameter
 * @author better
 * @date create in 2018/9/12 下午7:52
 */
public interface CodeGenerator<In, Out> {

    /**
     * 生成验证码方法，由子类实现自己的生成逻辑
     *
     * @param inParams 输入参数
     * @return
     */
    Out generatorCode(In... inParams);
}

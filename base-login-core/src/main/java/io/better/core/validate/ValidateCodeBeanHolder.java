package io.better.core.validate;

import io.better.core.validate.exception.ValidateCodeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

/**
 * The type Validate code processor holder.
 *
 * @author better create in 2018/10/3 12:22
 */
@Component
public class ValidateCodeBeanHolder {

    @Autowired
    private Map<String, ValidateCodeProcessor> processorMap;
    @Autowired
    private Map<String, ValidateCodeGenerator> generatorMap;
    
    /**
     * Gets validate code processor.
     *
     * @param key the key
     * @return the validate code processor
     */
    public ValidateCodeProcessor getValidateCodeProcessor(String key) {

        ValidateCodeProcessor validateCodeProcessor = processorMap.get(key);
        if (Objects.isNull(validateCodeProcessor)) {
            throw new ValidateCodeException(key + "is not exists");
        }
        return validateCodeProcessor;
    }

    /**
     * @param key the key
     * @return the validate code processor
     */
    public ValidateCodeGenerator getValidateCodeGenerator(String key) {

        ValidateCodeGenerator validateCodeProcessor = generatorMap.get(key);
        if (Objects.isNull(validateCodeProcessor)) {
            throw new ValidateCodeException(key + "is not exists");
        }
        return validateCodeProcessor;
    }
}

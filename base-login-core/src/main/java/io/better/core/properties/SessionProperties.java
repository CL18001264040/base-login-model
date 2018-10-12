package io.better.core.properties;

import lombok.Data;

/**
 * @author better
 * @date create in 2018/10/12 下午5:52
 */
@Data
public class SessionProperties {

    /**
     * session失效页面
     */
    private String sessionInvalidUrl = "";
}

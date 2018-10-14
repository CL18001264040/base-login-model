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
    private String sessionInvalidUrl = "/session-invalid";

    /**
     * Session最大数量
     */
    private Integer maximumSessions = 1;

    /**
     * 当session达到最大时，是否阻止新的登录
     */
    private Boolean maxSessionsPreventsLogin = Boolean.FALSE;
}

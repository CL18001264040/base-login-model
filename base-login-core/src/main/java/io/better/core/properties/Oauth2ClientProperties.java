package io.better.core.properties;

import lombok.Data;

/**
 * The type Oauth 2 client properties.
 *
 * @author better create in 2018/10/1 10:06
 */
@Data
public class Oauth2ClientProperties {

    /**
     * 客户ID，require is true
     */
    private String clientId;

    /**
     * 客户端秘钥
     */
    private String secret;

    /**
     * 授权范围
     */
    private String scope = "all";

    /**
     * 授权类型
     */
    private String authorizedGrantTypes;

    /**
     * accessToken失效时间
     */
    private Integer accessTokenValiditySeconds = 7200;
}
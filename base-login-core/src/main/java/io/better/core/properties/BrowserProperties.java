package io.better.core.properties;

import io.better.core.support.LoginType;
import lombok.Data;
import org.hibernate.Session;

/**
 * @author better create in 2018/10/1 09:57
 */
@Data
public class BrowserProperties {

    /**
     * 默认登录页面
     */
    private String loginPage = "/better-login.html";

    /**
     * 默认登录成功和失败的处理是为响应Json
     */
    private LoginType loginType = LoginType.JSON;

    /**
     * 登录成功的页面
     */
    private String successPage = "/index.html";

    /**
     * 退出的url
     */
    private String logoutUrl = "/logout";

    /**
     * 退出成功的url
     */
    private String logoutSuccessUrl = "/index";

    /**
     * session相关的配置
     */
    private SessionProperties sessionProp = new SessionProperties();
}

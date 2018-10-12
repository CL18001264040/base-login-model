package io.better.core.support;

import io.better.core.properties.BrowserProperties;

/**
 * 登录成功和失败的方式
 *
 * @author better create in 2018/10/2 08:09
 */
public enum LoginType {

    /**
     * 页面跳转
     */
    REDIRECT,

    /**
     * 响应Json
     */
    JSON;

    /**
     * Is json boolean.
     *
     * @param browserProperties the browser properties
     * @return the boolean
     */
    public static Boolean isJson(BrowserProperties browserProperties) {
        return browserProperties.getLoginType().equals(JSON);
    }

    /**
     * Is redirect boolean.
     *
     * @param browserProperties the browser properties
     * @return the boolean
     */
    public static Boolean isRedirect(BrowserProperties browserProperties) {
        return browserProperties.getLoginType().equals(REDIRECT);
    }
}

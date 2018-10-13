package io.better.browser.handler;

import com.alibaba.fastjson.JSON;
import io.better.core.support.SimpleResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Browser logout success handler.
 *
 * @author better create in 2018/10/13 21:43
 */
@Slf4j
public class BrowserLogoutSuccessHandler implements LogoutSuccessHandler {

    private final String logOutSuccessUrl;

    /**
     * Instantiates a new Browser logout success handler.
     *
     * @param logOutSuccessUrl the log out success url
     */
    public BrowserLogoutSuccessHandler(String logOutSuccessUrl) {
        this.logOutSuccessUrl = logOutSuccessUrl;
    }


    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

        if (StringUtils.isBlank(logOutSuccessUrl)) {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(JSON.toJSONString(SimpleResponse.response("退出成功")));
        } else {
            response.sendRedirect(logOutSuccessUrl);
        }
    }
}

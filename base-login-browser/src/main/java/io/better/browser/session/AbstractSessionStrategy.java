package io.better.browser.session;

import com.alibaba.fastjson.JSON;
import io.better.core.support.SimpleResponse;
import io.better.core.support.SuffixEnum;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Abstract session strategy.
 *
 * @author better
 * @date create in 2018/10/12 下午5:39
 */
@Data
public abstract class AbstractSessionStrategy {

    private final RedirectStrategy redirectStrategy;
    /**
     * session失效跳转的url
     */
    private String redirectUrl;
    /**
     * 是否创建session
     */
    private Boolean createNewSession = Boolean.TRUE;

    /**
     * Instantiates a new Abstract session strategy.
     *
     * @param sessionInvalidUrl the session invalid url
     */
    public AbstractSessionStrategy(String sessionInvalidUrl) {
        this.redirectUrl = sessionInvalidUrl;
        this.redirectStrategy = new DefaultRedirectStrategy();
    }

    /**
     * Session invalid.
     *
     * @param request  the request
     * @param response the response
     * @throws IOException the io exception
     */
    protected void sessionInvalid(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (createNewSession) {
            request.getSession();
        }

        String requestURI = request.getRequestURI();
        String finalRedirectUrl;

        if (StringUtils.endsWithIgnoreCase(requestURI, SuffixEnum.HTML.getSuffix())) {
            finalRedirectUrl = redirectUrl + SuffixEnum.HTML.getSuffix();
            redirectStrategy.sendRedirect(request, response, finalRedirectUrl);
        } else {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(JSON.toJSONString(SimpleResponse.response(isCurrent() ? "session invalid" : "并发登录")));
        }
    }

    protected Boolean isCurrent() {

        return Boolean.FALSE;
    }
}

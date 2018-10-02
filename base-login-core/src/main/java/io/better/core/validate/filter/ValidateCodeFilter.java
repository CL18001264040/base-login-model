package io.better.core.validate.filter;

import io.better.core.api.ValidateController;
import io.better.core.validate.exception.ValidateCodeException;
import io.better.core.validate.img.ImageCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionAttributeStore;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author better create in 2018/10/2 10:08
 */
public class ValidateCodeFilter extends OncePerRequestFilter {

    private final AuthenticationFailureHandler authenticationFailureHandler;
    private final SessionAttributeStore sessionAttributeStore;

    @Autowired
    public ValidateCodeFilter(AuthenticationFailureHandler authenticationFailureHandler) {
        this.authenticationFailureHandler = authenticationFailureHandler;
        this.sessionAttributeStore = new DefaultSessionAttributeStore();
    }

    /**
     * Same contract as for {@code doFilter}, but guaranteed to be
     * just invoked once per request within a single request thread.
     * See {@link #shouldNotFilterAsyncDispatch()} for details.
     * <p>Provides HttpServletRequest and HttpServletResponse arguments instead of the
     * default ServletRequest and ServletResponse ones.
     *
     * @param request
     * @param response
     * @param filterChain
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        if (isFormLogin(request)) {
            try {
                validateCode(new ServletWebRequest(request));
            } catch (ValidateCodeException exception) {
                authenticationFailureHandler.onAuthenticationFailure(request, response, exception);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    /**
     * 校验验证码
     *
     * @param request 请求信息
     */
    private void validateCode(ServletWebRequest request) throws ServletRequestBindingException {
        ImageCode imageCode = (ImageCode) sessionAttributeStore.retrieveAttribute(request, ValidateController.IMG_CODE_SESSION_KEY);

        String validateCode = ServletRequestUtils.getStringParameter(request.getRequest(), "validateCode");

        if (StringUtils.isBlank(validateCode)) {
            throw new ValidateCodeException("validateCode is not be empty");
        }

        if (Objects.isNull(imageCode)) {
            throw new ValidateCodeException("imageCode is not exits");
        }

        if (imageCode.isExpire()) {
            sessionAttributeStore.cleanupAttribute(request, ValidateController.IMG_CODE_SESSION_KEY);
            throw new ValidateCodeException("imageCode is expired");
        }

        if (StringUtils.equalsIgnoreCase(validateCode, imageCode.getCode())) {
            throw new ValidateCodeException("validateCode is not match");
        }
        sessionAttributeStore.cleanupAttribute(request, ValidateController.IMG_CODE_SESSION_KEY);
    }

    /**
     * 判断是否是表单登录并请求方式为POST
     *
     * @param request
     * @return
     */
    private Boolean isFormLogin(HttpServletRequest request) {
        return StringUtils.equals("/login/form", request.getRequestURI())
                && StringUtils.equalsIgnoreCase(HttpMethod.POST.name(), request.getMethod());
    }
}

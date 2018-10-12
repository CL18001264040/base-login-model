package io.better.core.validate.filter;

import io.better.core.validate.ValidateCode;
import io.better.core.validate.exception.ValidateCodeException;
import org.apache.commons.lang3.StringUtils;
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

import static io.better.core.support.Constant.*;

/**
 * The type Sms code filter.
 *
 * @author better create in 2018/10/2 10:08
 */
public class SmsCodeFilter extends OncePerRequestFilter {

    private final AuthenticationFailureHandler authenticationFailureHandler;
    private final SessionAttributeStore sessionAttributeStore;

    /**
     * Instantiates a new Sms code filter.
     *
     * @param authenticationFailureHandler the authentication failure handler
     */
    public SmsCodeFilter(AuthenticationFailureHandler authenticationFailureHandler) {
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
                validateSmsCode(new ServletWebRequest(request));
            } catch (ValidateCodeException exception) {
                authenticationFailureHandler.onAuthenticationFailure(request, response, exception);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    /**
     * 校验短信验证码
     *
     * @param request 请求信息
     */
    private void validateSmsCode(ServletWebRequest request) throws ServletRequestBindingException {
        // Session中获取图片短信验证码
        ValidateCode validateCode = (ValidateCode) sessionAttributeStore.retrieveAttribute(request, SMS_CODE_SESSION_KEY.getContent());
        // 取出request中的短信验证码
        String smsRequestCode = ServletRequestUtils.getStringParameter(request.getRequest(), SMS_CODE_REQ_PARAMETER.getContent());

        if (StringUtils.isBlank(smsRequestCode)) {
            throw new ValidateCodeException("smsCode is not be empty");
        }

        if (Objects.isNull(validateCode)) {
            throw new ValidateCodeException("smsCode is not exits");
        }

        if (validateCode.isExpire()) {
            sessionAttributeStore.cleanupAttribute(request, SMS_CODE_SESSION_KEY.getContent());
            throw new ValidateCodeException("smsCode is expired");
        }

        if (StringUtils.equalsIgnoreCase(smsRequestCode, validateCode.getCode())) {
            throw new ValidateCodeException("smsCode is not match");
        }
        sessionAttributeStore.cleanupAttribute(request, SMS_CODE_SESSION_KEY.getContent());
    }

    /**
     * 判断是否是表单登录并请求方式为POST
     *
     * @param request
     * @return
     */
    private Boolean isFormLogin(HttpServletRequest request) {
        return StringUtils.equals("/login/sms", request.getRequestURI())
                && StringUtils.equalsIgnoreCase(POST.getContent(), request.getMethod());
    }
}

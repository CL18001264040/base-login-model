package io.better.core.authentication.filter;

import io.better.core.authentication.token.SmsAuthenticationToken;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The type Sms authentication filter.
 *
 * @author better create in 2018/10/2 17:08
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SmsAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    /**
     * The constant SMS_FORM_CELLPHONE_KEY.
     */
    public static final String SMS_FORM_CELLPHONE_KEY = "cellPhone";

    private String cellPhoneParameter = SMS_FORM_CELLPHONE_KEY;

    private Boolean postOnly = true;

    /**
     * Instantiates a new Sms authentication filter.
     */
    public SmsAuthenticationFilter() {
        super(new AntPathRequestMatcher("/login/sms", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        if (postOnly && !request.getMethod().equals(HttpMethod.POST.name())) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }

        String cellPhone = obtainCellPhone(request);

        if (cellPhone == null) {
            cellPhone = "";
        }

        cellPhone = cellPhone.trim();
        SmsAuthenticationToken authRequest = new SmsAuthenticationToken(cellPhone);

        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }

    /**
     * 获取手机号
     *
     * @param request the request
     * @return the string
     */
    protected String obtainCellPhone(HttpServletRequest request) {
        return request.getParameter(cellPhoneParameter);
    }

    /**
     * 设置请求详情
     *
     * @param request     the request
     * @param authRequest the auth request
     */
    protected void setDetails(HttpServletRequest request, SmsAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }
}
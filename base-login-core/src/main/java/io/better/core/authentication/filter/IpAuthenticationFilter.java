package io.better.core.authentication.filter;

import io.better.core.authentication.token.IpAuthenticationToken;
import io.better.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ip认证的filter
 *
 * @author better
 * @date create in 2018/9/19 下午4:35
 */
public class IpAuthenticationFilter extends AbstractAuthenticationProcessingFilter {


    /**
     * Instantiates a new Ip authentication filter.
     *
     * @param securityProperties the security properties
     */
    public IpAuthenticationFilter(SecurityProperties securityProperties) {
        super(securityProperties.getAuthenticationProp().getIpAuthUrl());
    }

    /**
     * 获取ip,交给AuthenticationManager进行认证
     *
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {

        String requestIp = request.getRemoteHost();
        return getAuthenticationManager().authenticate(new IpAuthenticationToken(requestIp));
    }
}

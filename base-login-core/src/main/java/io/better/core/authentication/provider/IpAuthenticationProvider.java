package io.better.core.authentication.provider;

import io.better.core.authentication.token.IpAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 提供ip认证服务
 *
 * @author better
 * @date create in 2018/9/19 下午4:50
 */
public class IpAuthenticationProvider implements AuthenticationProvider {

    private Map<String, GrantedAuthority> authorityMap = new ConcurrentHashMap<>();

    /**
     * 认证
     *
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        IpAuthenticationToken ipAuthenticationToken = (IpAuthenticationToken) authentication;
        return ipAuthenticationToken;
    }

    /**
     * 是否支持，不支持则不调用authenticate方法
     *
     * @param authentication
     * @return
     */
    @Override
    public boolean supports(Class<?> authentication) {
        /*判断token是否为IPAuthenticationToken类型*/
        return IpAuthenticationToken.class.isAssignableFrom(authentication);
    }
}

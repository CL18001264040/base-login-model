package io.better.core.authentication.provider;

import io.better.core.authentication.token.SmsAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Objects;

/**
 * The type Sms authentication provider.
 *
 * @author better create in 2018/10/2 17:09
 */
public class SmsAuthenticationProvider implements AuthenticationProvider {

    private UserDetailsService userDetailsService;

    /**
     * Instantiates a new Sms authentication provider.
     *
     * @param userDetailsService the user details service
     */
    public SmsAuthenticationProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    /**
     * 提供处理sms登录的逻辑
     *
     * @param authentication 自定义的SmsAuthenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        SmsAuthenticationToken smsAuthenticationToken = (SmsAuthenticationToken) authentication;
        UserDetails user = userDetailsService.loadUserByUsername((String) smsAuthenticationToken.getPrincipal());
        if (Objects.isNull(user)) {
            throw new InternalAuthenticationServiceException("Cannot get user information with cellPhone => " + smsAuthenticationToken.getPrincipal());
        }
        SmsAuthenticationToken verified = new SmsAuthenticationToken(user, user.getAuthorities());
        verified.setDetails(smsAuthenticationToken.getDetails());
        return verified;
    }

    /**
     * 传入的Authentication对象，是否支持当前
     *
     * @param authentication authentication class信息
     * @return
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return SmsAuthenticationToken.class.isAssignableFrom(authentication);
    }
}

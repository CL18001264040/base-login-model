package io.better.core.authentication.provider;

import io.better.core.authentication.token.JwtAuthenticationToken;
import io.better.rbac.servoce.UsersService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * @author better
 * @date create in 2018/11/16 4:44 PM
 */
public class JwtAuthenticationProvider implements AuthenticationProvider {

    private UsersService usersService;

    /**
     * Instantiates a new Sms authentication provider.
     *
     * @param usersService the users service
     */
    public JwtAuthenticationProvider(UsersService usersService) {
        this.usersService = usersService;
    }

    /**
     *
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }

    /**
     *
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthenticationToken.class.isAssignableFrom(authentication);
    }
}

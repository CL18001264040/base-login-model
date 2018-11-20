package io.better.core.authentication.token;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author better
 * @date create in 2018/11/16 4:43 PM
 */
public class JwtAuthenticationToken extends AbstractAuthenticationToken {
    private final Object principal;

    /**
     * @param principal the principal
     */
    public JwtAuthenticationToken(Object principal) {
        super(null);
        this.principal = principal;
        setAuthenticated(false);
    }

    /**
     *
     */
    public JwtAuthenticationToken(Object principal, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        super.setAuthenticated(true);
    }

    /**
     *
     */
    @Override
    public Object getCredentials() {
        return null;
    }

    /**
     *
     */
    @Override
    public Object getPrincipal() {
        return null;
    }
}

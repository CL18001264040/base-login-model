package io.better.core.authentication.token;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

import static java.lang.Boolean.FALSE;

/**
 * Ip认证的token
 *
 * @author better
 * @date create in 2018/9/19 下午4:41
 */
public class IpAuthenticationToken extends AbstractAuthenticationToken {

    @Getter
    @Setter
    private String ip;

    /**
     * 认证时使用
     *
     * @param ip the ip
     */
    public IpAuthenticationToken(String ip) {
        super(null);
        this.ip = ip;
        this.setAuthenticated(FALSE);
    }

    /**
     * 认证后使用
     *
     * @param ip the ip
     */
    public IpAuthenticationToken(String ip, Collection<GrantedAuthority> authorities) {
        super(authorities);
        this.ip = ip;
    }

    @Override
    public Object getCredentials() {
        return null;
    }


    @Override
    public Object getPrincipal() {
        return null;
    }
}

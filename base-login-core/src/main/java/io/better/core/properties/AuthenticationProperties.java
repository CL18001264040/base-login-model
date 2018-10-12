package io.better.core.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Authentication properties.
 *
 * @author better
 * @date create in 2018/9/19 下午4:39
 */
@Getter
@Setter
@ToString
public class AuthenticationProperties {

    /**
     * ip认证的url
     */
    private String ipAuthUrl = "/ip";

    /**
     * 权限
     */
    private List<GrantedAuthority> authorities;


    /**
     * Sets authorities.
     *
     * @param authorities the authorities
     */
    public void setAuthorities(String authorities) {
        String[] authorityArray = StringUtils.split(authorities, ",");

        this.authorities = Arrays.stream(authorityArray)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}

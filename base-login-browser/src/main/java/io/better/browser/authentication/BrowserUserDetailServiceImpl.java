package io.better.browser.authentication;

import io.better.rbac.model.Users;
import io.better.rbac.servoce.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * The type Browser user detail service.
 *
 * @author better
 * @date create in 2018/9/30 下午2:23
 */
@Component
@Slf4j
public class BrowserUserDetailServiceImpl implements UserDetailsService {

    private final UsersService usersService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public BrowserUserDetailServiceImpl(UsersService usersService, PasswordEncoder passwordEncoder) {
        this.usersService = usersService;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users = usersService.getUsersByUserName(username);
        if (Objects.isNull(users)) {
            throw new UsernameNotFoundException("user info is not exists with username => " + username);
        }
        return new User(users.getUserName(), passwordEncoder.encode(users.getPassword()),
                AuthorityUtils.commaSeparatedStringToAuthorityList("ADMIN"));
    }
}

package io.better.rbac.model;

import io.better.rbac.common.BaseModel;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * @author better
 * @date create in 2018/9/30 下午3:28
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "tbl_users")
@Entity
public class Users extends BaseModel<Long> implements UserDetails {

    /**
     * 昵称
     */
    @Column(name = "nick_name", nullable = false)
    private String nickName;

    /**
     * 用户名
     */
    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    /**
     * 密码
     */
    @Column(name = "password", nullable = false, unique = true)
    private String password;

    /**
     * 唯一ID
     */
    @Column(name = "unique_id", nullable = true, unique = false)
    private String uniqueId;

    /**
     * 状态
     */
    @Enumerated(value = EnumType.STRING)
    @Column(name = "state")
    private State state;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 电话
     */
    @Column(name = "cell_phone", unique = true)
    private String cellPhone;

    /**
     * 地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 分组唯一ID
     */
    @Column(name = "group_unique_id")
    private String groupUniqueId;

    /**
     * 用户 -> 角色集合
     */
    @Transient
    private List<Roles> roles;

    /**
     * Returns the authorities granted to the user. Cannot return <code>null</code>.
     *
     * @return the authorities, sorted by natural key (never <code>null</code>)
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /**
     * Returns the username used to authenticate the user. Cannot return <code>null</code>
     * .
     *
     * @return the username (never <code>null</code>)
     */
    @Override
    public String getUsername() {
        return this.userName;
    }

    /**
     * Indicates whether the user's account has expired. An expired account cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user's account is valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is locked or unlocked. A locked user cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user is not locked, <code>false</code> otherwise
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials (password) has expired. Expired
     * credentials prevent authentication.
     *
     * @return <code>true</code> if the user's credentials are valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled or disabled. A disabled user cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user is enabled, <code>false</code> otherwise
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}

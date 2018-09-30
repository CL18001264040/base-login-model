package io.better.rbac.model;

import io.better.rbac.common.BaseModel;
import lombok.*;

import javax.persistence.*;
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
public class Users extends BaseModel<Long> {

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
}

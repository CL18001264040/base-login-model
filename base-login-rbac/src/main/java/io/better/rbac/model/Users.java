package io.better.rbac.model;

import io.better.rbac.common.BaseModel;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
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
    private String nickName;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 唯一ID
     */
    private String uniqueId;

    /**
     * 状态
     */
    private State state;

    /**
     * 分组唯一ID
     */
    private String groupUniqueId;

    /**
     * 用户 -> 角色集合
     */
    @Transient
    private List<Roles> roles;
}

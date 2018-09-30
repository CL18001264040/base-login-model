package io.better.rbac.model;

import io.better.rbac.common.BaseModel;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * The type Roles.
 *
 * @author better
 * @date create in 2018/9/30 下午3:28
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "tbl_roles")
@Entity
public class Roles extends BaseModel<Long> {

    /**
     * 角色名称
     */
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    /**
     * 角色表达式
     */
    @Column(name = "expression", nullable = false)
    private String expression;

    /**
     * 角色唯一ID
     */
    @Column(name = "unique_id", nullable = false, unique = true)
    private String uniqueId;

    /**
     * 角色状态
     */
    @Enumerated(value = EnumType.STRING)
    @Column(name = "state")
    private State state;

    /**
     * 角色 -> 权限集合
     */
    @Transient
    private List<Permissions> permissions;
}

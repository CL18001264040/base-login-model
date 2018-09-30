package io.better.rbac.model;

import io.better.rbac.common.BaseModel;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author better
 * @date create in 2018/9/30 下午3:32
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "tbl_groups")
@Entity
public class Groups extends BaseModel<Long> {

    /**
     * 分组名称
     */
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    /**
     * 组唯一ID
     */
    @Column(name = "unique_id", nullable = false, unique = true)
    private String uniqueId;

    /**
     * 父分组ID
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 分组状态
     */
    @Column(name = "state", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private State state;

    /**
     * 分组 -> 多个用户
     */
    @Transient
    private List<Users> users;

    /**
     * 分组 -> 多个角色
     */
    @Transient
    private List<Roles> roles;
}

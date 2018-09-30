package io.better.rbac.model;

import io.better.rbac.common.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author better
 * @date create in 2018/9/30 下午3:32
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "group_role")
@Entity
public class GroupRole extends BaseModel<Long> {

    /**
     * 分组唯一ID
     */
    @Column(name = "group_unique_id")
    private String groupUniqueId;

    /**
     * 角色唯一ID
     */
    @Column(name = "roles_unique_id")
    private String rolesUniqueId;
}

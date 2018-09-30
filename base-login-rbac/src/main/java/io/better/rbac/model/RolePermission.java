package io.better.rbac.model;

import io.better.rbac.common.BaseModel;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The type Role permission.
 *
 * @author better
 * @date create in 2018/9/30 下午3:28
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "tbl_role_permission")
@Entity
public class RolePermission extends BaseModel<Long> {

    /**
     * 角色唯一ID
     */
    private String roleUniqueId;

    /**
     * 权限唯一ID
     */
    private String permissionUniqueId;
}

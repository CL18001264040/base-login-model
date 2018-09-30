package io.better.rbac.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.better.rbac.common.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Role permission.
 *
 * @author better
 * @date create in 2018/9/30 下午3:28
 */
@Getter
@Setter
@TableName(value = "role_permission")
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

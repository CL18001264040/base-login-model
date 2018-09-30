package io.better.rbac.servoce;

import io.better.rbac.model.Permissions;
import io.better.rbac.model.Roles;

import java.util.List;

/**
 * The interface Permissions service.
 *
 * @author better
 * @date create in 2018/9/30 下午4:56
 */
public interface PermissionsService {

    /**
     * 根据角色 -> 获取权限集合
     *
     * @param roles 角色信息
     * @return
     */
    List<Permissions> listPermissionsByRoles(Roles roles);
}

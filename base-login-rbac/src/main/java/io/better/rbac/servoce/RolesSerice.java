package io.better.rbac.servoce;

import io.better.rbac.model.Roles;
import io.better.rbac.model.Users;

import java.util.List;

/**
 * @author better
 * @date create in 2018/9/30 下午4:19
 */
public interface RolesSerice {

    /**
     * 根据用户 -> 获取角色集合
     *
     * @param users
     * @return
     */
    List<Roles> listRolesByUser(Users users);
}

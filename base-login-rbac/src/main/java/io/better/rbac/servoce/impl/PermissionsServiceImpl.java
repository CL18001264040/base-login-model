package io.better.rbac.servoce.impl;

import io.better.rbac.model.Permissions;
import io.better.rbac.model.Roles;
import io.better.rbac.servoce.PermissionsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author better
 * @date create in 2018/9/30 下午5:25
 */
@Service
public class PermissionsServiceImpl implements PermissionsService {

    /**
     * 根据角色 -> 获取权限集合
     *
     * @param roles 角色信息
     * @return
     */
    @Override
    public List<Permissions> listPermissionsByRoles(Roles roles) {
        return null;
    }
}

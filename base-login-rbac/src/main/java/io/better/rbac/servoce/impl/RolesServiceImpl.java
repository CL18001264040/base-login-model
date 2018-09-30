package io.better.rbac.servoce.impl;

import io.better.rbac.model.Roles;
import io.better.rbac.model.Users;
import io.better.rbac.servoce.RolesService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author better
 * @date create in 2018/9/30 下午5:38
 */
@Service
public class RolesServiceImpl implements RolesService {

    /**
     * 根据用户 -> 获取角色集合
     *
     * @param users
     * @return
     */
    @Override
    public List<Roles> listRolesByUser(Users users) {
        return null;
    }
}

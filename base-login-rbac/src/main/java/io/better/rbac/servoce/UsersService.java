package io.better.rbac.servoce;

import io.better.rbac.model.Group;
import io.better.rbac.model.Users;

import java.util.List;

/**
 * @author better
 * @date create in 2018/9/30 下午4:56
 */
public interface UsersService {

    /**
     * 根据分组 -> 获取用户集合
     *
     * @param group
     * @return
     */
    List<Users> listUsersByGroup(Group group);
}

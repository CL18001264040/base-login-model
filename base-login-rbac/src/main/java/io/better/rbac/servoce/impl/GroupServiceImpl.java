package io.better.rbac.servoce.impl;

import io.better.rbac.model.Group;
import io.better.rbac.model.Users;
import io.better.rbac.servoce.GroupService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author better
 * @date create in 2018/9/30 下午5:45
 */
@Service
public class GroupServiceImpl implements GroupService {

    /**
     * 根据分组 -> 获取用户集合
     *
     * @param group
     * @return
     */
    @Override
    public List<Users> listUsersByGroup(Group group) {
        return null;
    }
}

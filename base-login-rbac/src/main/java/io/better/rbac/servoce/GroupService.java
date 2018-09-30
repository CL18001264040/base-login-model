package io.better.rbac.servoce;

import io.better.rbac.model.Group;
import io.better.rbac.model.dto.GroupDto;
import io.better.rbac.model.dto.UsersDto;

import java.util.List;

/**
 * @author better
 * @date create in 2018/9/30 下午4:55
 */
public interface GroupService {

    /**
     * 根据分组 -> 获取用户集合
     *
     * @param group
     * @return
     */
    List<UsersDto> listUsersByGroup(Group group);
}

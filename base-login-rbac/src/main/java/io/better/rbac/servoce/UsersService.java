package io.better.rbac.servoce;

import io.better.rbac.model.Users;
import io.better.rbac.model.dto.UsersDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * The interface Users service.
 *
 * @author better
 * @date create in 2018/9/30 下午4:56
 */
public interface UsersService {

    /**
     * 获取所有的用户
     *
     * @param pageable the pageable
     * @return page page
     */
    Page<Users> listUsers(Pageable pageable);

    /**
     * 根据分组 -> 获取用户集合
     *
     * @param groupUniqueId the group unique id
     * @return list
     */
    List<UsersDto> listUsersByGroupId(String groupUniqueId);
}

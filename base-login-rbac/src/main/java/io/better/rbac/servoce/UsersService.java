package io.better.rbac.servoce;

import io.better.rbac.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
     * @return page
     */
    Page<Users> listUsers(Pageable pageable);
}

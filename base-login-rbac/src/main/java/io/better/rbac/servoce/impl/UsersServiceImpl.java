package io.better.rbac.servoce.impl;

import io.better.rbac.model.Users;
import io.better.rbac.repository.UsersRepository;
import io.better.rbac.servoce.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author better
 * @date create in 2018/9/30 下午5:39
 */
@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    /**
     * 获取所有的用户
     *
     * @return
     */
    @Override
    public Page<Users> listUsers(Pageable pageable) {
        return usersRepository.findAll(pageable);
    }

}

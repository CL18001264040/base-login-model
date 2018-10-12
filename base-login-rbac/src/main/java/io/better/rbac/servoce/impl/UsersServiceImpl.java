package io.better.rbac.servoce.impl;

import io.better.rbac.model.Users;
import io.better.rbac.model.dto.UsersDto;
import io.better.rbac.repository.UsersRepository;
import io.better.rbac.servoce.UsersService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.LinkedList;
import java.util.List;

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
     * 根据用户名获取到用户信息
     *
     * @param userName
     * @return
     */
    @Override
    public Users getUsersByUserName(String userName) {

        List<Predicate> predicates = new LinkedList<>();

        return usersRepository.findOne((root, query, cb) -> {
            if (StringUtils.isNoneBlank(userName)) {
                predicates.add(cb.equal(root.get("userName"), userName));
            }
            query.where(predicates.toArray(new Predicate[predicates.size()]));
            return query.getRestriction();
        });
    }

    /**
     * 根据电话查询用户
     *
     * @param cellPhone 电话
     * @return
     */
    @Override
    public Users getUsersByCellPhone(String cellPhone) {
        List<Predicate> predicates = new LinkedList<>();

        return usersRepository.findOne((root, query, cb) -> {
            if (StringUtils.isNoneBlank(cellPhone)) {
                predicates.add(cb.equal(root.get("cellPhone"), cellPhone));
            }
            query.where(predicates.toArray(new Predicate[predicates.size()]));
            return query.getRestriction();
        });
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


    /**
     * 根据分组 -> 获取用户集合
     *
     * @param groupUniqueId the group unique id
     * @return list
     */
    @Override
    public List<UsersDto> listUsersByGroupId(String groupUniqueId) {

        List<Predicate> predicates = new LinkedList<>();

        List<Users> result = usersRepository.findAll((root, query, cb) -> {
            if (StringUtils.isNoneBlank(groupUniqueId)) {
                predicates.add(cb.equal(root.get("groupUniqueId"), groupUniqueId));
            }
            query.where(predicates.toArray(new Predicate[predicates.size()]));
            return query.getRestriction();
        });
        return UsersDto.parseUsers(result);
    }
}

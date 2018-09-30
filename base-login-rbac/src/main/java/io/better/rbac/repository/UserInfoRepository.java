package io.better.rbac.repository;

import io.better.rbac.model.UsersInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * The interface Users repository.
 *
 * @author better
 * @date create in 2018/9/30 下午5:30
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UsersInfo, Long>, JpaSpecificationExecutor<UsersInfo> {
}

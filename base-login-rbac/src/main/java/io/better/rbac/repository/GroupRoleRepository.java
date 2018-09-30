package io.better.rbac.repository;

import io.better.rbac.model.GroupRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * The interface Group user repository.
 *
 * @author better
 * @date create in 2018/9/30 下午5:46
 */
@Repository
public interface GroupRoleRepository extends JpaRepository<GroupRole, Long>, JpaSpecificationExecutor<GroupRole> {
}

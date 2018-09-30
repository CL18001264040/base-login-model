package io.better.rbac.repository;

import io.better.rbac.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * The interface Roles repository.
 *
 * @author better
 * @date create in 2018/9/30 下午5:31
 */
@Repository
public interface RolesRepository extends JpaRepository<Roles, Long>, JpaSpecificationExecutor<Roles> {
}

package io.better.rbac.repository;

import io.better.rbac.model.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * The interface Permissions repository.
 *
 * @author better
 * @date create in 2018/9/30 下午5:29
 */
@Repository
public interface PermissionsRepository extends JpaRepository<Permissions, Long>, JpaSpecificationExecutor<Permissions> {
}

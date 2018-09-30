package io.better.rbac.model;

import io.better.rbac.common.BaseModel;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author better
 * @date create in 2018/9/30 下午3:28
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "tbl_user_role")
@Entity
public class UserRole extends BaseModel<Long> {

    /**
     * 用户唯一ID
     */
    private String usersUniqueId;

    /**
     * 角色唯一ID
     */
    private String roleUniqueId;
}

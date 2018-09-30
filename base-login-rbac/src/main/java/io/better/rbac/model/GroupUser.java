package io.better.rbac.model;

import io.better.rbac.common.BaseModel;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author better
 * @date create in 2018/9/30 下午3:32
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "group_user")
@Entity
public class GroupUser extends BaseModel<Long> {

    /**
     * 组唯一ID
     */
    private String groupUniqueId;

    /**
     * 用户唯一ID
     */
    private String usersUniqueId;
}

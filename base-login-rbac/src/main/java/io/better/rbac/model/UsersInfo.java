package io.better.rbac.model;

import io.better.rbac.common.BaseModel;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author better
 * @date create in 2018/9/30 下午3:58
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "tbl_users_info")
@Entity
public class UsersInfo extends BaseModel<Long> {

    /**
     * 电话
     */
    private String cellPhone;

    /**
     * 地址
     */
    private String address;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户唯一ID
     */
    private String userUniqueId;
}

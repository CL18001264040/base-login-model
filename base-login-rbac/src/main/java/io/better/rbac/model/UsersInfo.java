package io.better.rbac.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.better.rbac.common.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author better
 * @date create in 2018/9/30 下午3:58
 */
@Getter
@Setter
@TableName(value = "users_info")
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

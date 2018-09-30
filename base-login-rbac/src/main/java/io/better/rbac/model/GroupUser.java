package io.better.rbac.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.better.rbac.common.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author better
 * @date create in 2018/9/30 下午3:32
 */
@Getter
@Setter
@TableName(value = "group_user")
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

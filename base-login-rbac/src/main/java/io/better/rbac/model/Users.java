package io.better.rbac.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.better.rbac.common.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Transient;
import java.util.List;

/**
 * @author better
 * @date create in 2018/9/30 下午3:28
 */
@Getter
@Setter
@TableName(value = "users")
public class Users extends BaseModel<Long> {

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 唯一ID
     */
    private String uniqueId;

    /**
     * 状态
     */
    private State state;

    /**
     * 用户 -> 角色集合
     */
    @Transient
    private List<Roles> roles;
}

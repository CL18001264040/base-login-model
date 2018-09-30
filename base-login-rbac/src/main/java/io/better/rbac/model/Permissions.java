package io.better.rbac.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.better.rbac.common.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author better
 * @date create in 2018/9/30 下午3:28
 */
@Getter
@Setter
@TableName(value = "permissions")
public class Permissions extends BaseModel<Long> {

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限表达式
     */
    private String expression;

    /**
     * 权限状态
     */
    private State state;
}

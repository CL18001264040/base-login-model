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
@Table(name = "permissions")
@Entity
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

package io.better.rbac.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * The type Base model.
 *
 * @param <T> the type parameter
 * @author better
 * @date create in 2018/9/30 下午3:03
 */
@Getter
@Setter
@MappedSuperclass
public class BaseModel<T> implements Serializable {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private T id;

    /**
     * 是否有效
     */
    private Boolean enable = Boolean.TRUE;

    /**
     * 创建者
     */
    private String createUser;

    /**
     * 创建时间
     */
    @CreatedDate
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /**
     * 更新者
     */
    private String updateUser;

    /**
     * 更新时间
     */
    @LastModifiedDate
    @Column(name = "update_time")
    private LocalDateTime updateTime;
}

package io.better.rbac.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author better
 * @date create in 2018/9/30 下午5:52
 */
@Getter
@Setter
@ToString
public class GroupDto implements Serializable {

    private String name;

    private String uniqueId;

    private String parentId;

    private List<RolesDto> rolesDtoList;

    private List<UsersDto> usersDtoList;
}

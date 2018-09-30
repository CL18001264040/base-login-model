package io.better.rbac.model.dto;

import io.better.rbac.model.Users;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author better
 * @date create in 2018/9/30 下午5:52
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto implements Serializable {

    private String userName;

    private String password;

    /**
     * 转换Users -> UserDto
     *
     * @param users 用户集合
     * @return
     */
    public static List<UsersDto> parseUsers(List<Users> users) {

        return users.stream()
                .map(user -> {
                    UsersDto usersDto = new UsersDto();
                    BeanUtils.copyProperties(user, usersDto);
                    return usersDto;
                })
                .collect(Collectors.toList());
    }
}

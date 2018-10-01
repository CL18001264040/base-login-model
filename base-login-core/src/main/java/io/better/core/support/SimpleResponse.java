package io.better.core.support;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author better create in 2018/10/1 10:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleResponse<T> {

    /**
     * 相应数据
     */
    private T data;


    /**
     * 工具类
     *
     * @param data 数据
     * @param <T>  泛型
     * @return
     */
    public static <T> SimpleResponse<T> response(T data) {
        return new SimpleResponse<>(data);
    }
}

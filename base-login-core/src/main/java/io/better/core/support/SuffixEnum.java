package io.better.core.support;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author better create in 2018/10/1 10:18
 */
@Getter
@AllArgsConstructor
public enum SuffixEnum {

    /**
     * HTML后缀
     */
    HTML(".html");

    /**
     * 后缀名称
     */
    private String suffix;
}

package io.better.core.properties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author better
 * @date create in 2018/9/12 下午8:00
 */
@Setter
@Getter
@ToString
public class ImageCodeProperties {

    /**
     * 图片的高
     */
    private Integer width = 250;

    /**
     * 图片的高
     */
    private Integer height = 30;

    /**
     * 图片验证码长度
     */
    private Integer length = 6;

    /**
     * 过期时间
     */
    private Integer expireTime = 60;

    /**
     * 是否有字母
     */
    private Boolean hasLetter = Boolean.TRUE;
}

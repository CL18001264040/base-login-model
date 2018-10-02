package io.better.core.validate.img;

import io.better.core.validate.ValidateCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * The type Image code.
 *
 * @author better create in 2018/10/2 10:20
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ImageCode extends ValidateCode {

    private static final long serialVersionUID = 6808424861880816916L;
    /**
     * 生成的图片
     */
    private BufferedImage image;

    /**
     * Instantiates a new Image code.
     *
     * @param image      the image
     * @param code       the code
     * @param expireTime the expire time
     */
    public ImageCode(BufferedImage image, String code, Long expireTime) {
        super(code, expireTime);
        this.image = image;
    }

    /**
     * Instantiates a new Image code.
     *
     * @param image      the image
     * @param code       the code
     * @param expireTime the expire time
     */
    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        super(code, expireTime);
        this.image = image;
    }
}

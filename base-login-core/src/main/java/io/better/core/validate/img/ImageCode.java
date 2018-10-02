package io.better.core.validate.img;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * The type Image code.
 *
 * @author better create in 2018/10/2 10:20
 */
@Data
public class ImageCode implements Serializable {

    private static final long serialVersionUID = 4701256229331697097L;

    /**
     *
     */
    private BufferedImage image;

    /**
     *
     */
    private String code;

    /**
     *
     */
    private LocalDateTime expireTime;


    /**
     * Instantiates a new Image code.
     *
     * @param image      the image
     * @param code       the code
     * @param expireTime the expire time
     */
    public ImageCode(BufferedImage image, String code, Long expireTime) {
        this.image = image;
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireTime);
    }

    /**
     * Instantiates a new Image code.
     *
     * @param image      the image
     * @param code       the code
     * @param expireTime the expire time
     */
    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        this.image = image;
        this.code = code;
        this.expireTime = expireTime;
    }

    /**
     * Is expire boolean.
     *
     * @return the boolean
     */
    public Boolean isExpire() {
        return LocalDateTime.now().isAfter(expireTime);
    }
}

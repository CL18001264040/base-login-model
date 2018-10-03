package io.better.core.validate.img;

import io.better.core.properties.SecurityProperties;
import io.better.core.validate.ValidateCode;
import io.better.core.validate.ValidateCodeGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * The type Image code generator.
 *
 * @author better
 * @date create in 2018/9/12 下午7:51
 */
@Slf4j
public class ImageValidateCodeGenerator implements ValidateCodeGenerator {

    private final SecurityProperties securityProperties;

    /**
     * Instantiates a new Image code generator.
     *
     * @param securityProperties the security properties
     */
    public ImageValidateCodeGenerator(final SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    /**
     * 生成验证码方法，由子类实现自己的生成逻辑
     *
     * @param request the request
     * @return validate code
     */
    @Override
    public ValidateCode generatorCode(ServletWebRequest request) {
        int width = ServletRequestUtils.getIntParameter(request.getRequest(), "width",
                securityProperties.getValidate().getImg().getWidth());
        int height = ServletRequestUtils.getIntParameter(request.getRequest(), "height",
                securityProperties.getValidate().getImg().getHeight());
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = image.getGraphics();

        Random random = new Random();

        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        g.setColor(getRandColor(160, 200));

        for (int i = 0, num = 155; i < num; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }

        String sRand = "";
        for (int i = 0; i < securityProperties.getValidate().getImg().getLength(); i++) {
            String rand = String.valueOf(random.nextInt(10));
            sRand += rand;
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(rand, 13 * i + 6, 16);
        }

        g.dispose();

        return new ImageCode(image, sRand, securityProperties.getValidate().getImg().getExpire());
    }

    /**
     * 生成随机背景条纹
     *
     * @param fc
     * @param bc
     * @return
     */
    private Color getRandColor(int fc, int bc) {
        int num = 255;
        Random random = new Random();
        if (fc > num) {
            fc = 255;
        }
        if (bc > num) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
}

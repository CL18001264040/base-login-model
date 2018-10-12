package io.better.core.social.qq.api;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author better create in 2018/10/7 18:52
 */
@Data
public class QQUserInfo implements Serializable {

    private static final long serialVersionUID = 4731266594456286706L;

    /**
     * 返回码
     */
    private Integer ret;

    /**
     * 返回消息
     */
    private String msg;

    /**
     * 用户标识
     */
    private String openId;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 大小为30×30像素的QQ空间头像URL
     */
    @JSONField(name = "figureurl")
    private String figureUrl;

    /**
     * 大小为50×50像素的QQ空间头像URL
     */
    @JSONField(name = "figureurl_1")
    private String figureUrl1;

    /**
     * 大小为100×100像素的QQ空间头像URL
     */
    @JSONField(name = "figureurl_2")
    private String figureUrl2;

    /**
     * 大小为40×40像素的QQ头像URL
     */
    @JSONField(name = "figureurl_qq_1")
    private String figureUrlQq1;

    /**
     * 大小为100×100像素的QQ头像URL。需要注意，不是所有的用户都拥有QQ的100x100的头像，但40x40像素则是一定会有
     */
    @JSONField(name = "figureurl_qq_2")
    private String figureUrlQq2;

    /**
     * 性别
     */
    private String gender;
}

package io.better.core.properties;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * @author better create in 2018/10/1 10:06
 */
@Data
public class Oauth2Properties {

    /**
     * 配置的客户端属性
     */
    private List<Oauth2ClientProperties> clients = new LinkedList<>();
}

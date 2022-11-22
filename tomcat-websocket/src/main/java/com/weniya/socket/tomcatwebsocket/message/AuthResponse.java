package com.weniya.socket.tomcatwebsocket.message;// AuthResponse.java

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 温笙
 */
@Data
@Builder
public class AuthResponse implements Message {

    public static final String TYPE = "AUTH_RESPONSE";

    /**
     * 响应状态码
     */
    private Integer code;
    /**
     * 响应提示
     */
    private String message;



}
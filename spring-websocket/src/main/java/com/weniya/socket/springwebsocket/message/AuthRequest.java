package com.weniya.socket.springwebsocket.message;

import lombok.Builder;
import lombok.Data;

/**
 * @author 温笙
 */
@Data
@Builder
public class AuthRequest implements Message {

    public static final String TYPE = "AUTH_REQUEST";

    /**
     * 认证 Token
     */
    private String accessToken;

}
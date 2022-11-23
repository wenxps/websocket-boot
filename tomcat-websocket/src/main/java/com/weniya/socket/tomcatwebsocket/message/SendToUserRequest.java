package com.weniya.socket.tomcatwebsocket.message;

import lombok.Builder;
import lombok.Data;

/**
 * @author 温笙
 * 在服务端接收到发送消息的请求，需要转发消息给对应的人
 */
@Data
@Builder
public class SendToUserRequest implements Message {

    public static final String TYPE = "SEND_TO_USER_REQUEST";

    /**
     * 消息编号
     */
    private String msgId;
    /**
     * 内容
     */
    private String content;
    
}
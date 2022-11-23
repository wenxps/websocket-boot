package com.weniya.socket.springwebsocket.message;

import lombok.Data;

/**
 * @author 温笙
 * 发送给所有人的群聊消息的 Message
 */
@Data
public class SendToAllRequest implements Message {

    public static final String TYPE = "SEND_TO_ALL_REQUEST";

    /**
     * 消息编号
     */
    private String msgId;
    /**
     * 内容
     */
    private String content;
    
}
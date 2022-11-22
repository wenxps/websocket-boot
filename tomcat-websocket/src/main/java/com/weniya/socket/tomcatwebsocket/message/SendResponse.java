package com.weniya.socket.tomcatwebsocket.message;

import lombok.Builder;
import lombok.Data;

/**
 * @author 温笙
 * 在服务端接收到发送消息的请求，需要异步响应发送是否成功
 *发送消息响应结果的 Message
 */
@Data
@Builder
public class SendResponse implements Message {

    public static final String TYPE = "SEND_RESPONSE";

    /**
     * 消息编号
     */
    private String msgId;
    /**
     * 响应状态码
     */
    private Integer code;
    /**
     * 响应提示
     */
    private String message;
    
}
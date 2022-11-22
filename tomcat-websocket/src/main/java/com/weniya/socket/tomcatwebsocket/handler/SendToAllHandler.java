package com.weniya.socket.tomcatwebsocket.handler;

import com.weniya.socket.tomcatwebsocket.message.SendResponse;
import com.weniya.socket.tomcatwebsocket.message.SendToAllRequest;
import com.weniya.socket.tomcatwebsocket.message.SendToUserRequest;
import com.weniya.socket.tomcatwebsocket.util.WebSocketUtil;
import org.springframework.stereotype.Component;

import javax.websocket.Session;

/**
 * @author 温笙
 */
@Component
public class SendToAllHandler implements MessageHandler<SendToAllRequest> {

    @Override
    public void execute(Session session, SendToAllRequest message) {
        // 这里，假装直接成功
        SendResponse sendResponse = SendResponse.builder().msgId(message.getMsgId()).code(0).build();
        WebSocketUtil.send(session, SendResponse.TYPE, sendResponse);

        // 创建转发的消息
        SendToUserRequest sendToUserRequest = SendToUserRequest.builder().msgId(message.getMsgId()).content(message.getContent()).build();
        // 广播发送
        WebSocketUtil.broadcast(SendToUserRequest.TYPE, sendToUserRequest);
    }

    @Override
    public String getType() {
        return SendToAllRequest.TYPE;
    }

}
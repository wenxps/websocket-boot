package com.weniya.socket.springwebsocket.handler;// SendToOneRequest.java

import com.weniya.socket.springwebsocket.handler.MessageHandler;

import com.weniya.socket.springwebsocket.message.SendResponse;
import com.weniya.socket.springwebsocket.message.SendToOneRequest;
import com.weniya.socket.springwebsocket.message.SendToUserRequest;
import com.weniya.socket.springwebsocket.util.WebSocketUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import javax.websocket.Session;

/**
 * @author 温笙
 */
@Component
public class SendToOneHandler implements MessageHandler<SendToOneRequest> {

    @Override
    public void execute(WebSocketSession session, SendToOneRequest message) {
        // 这里，假装直接成功
        SendResponse sendResponse = SendResponse.builder().msgId(message.getMsgId()).code(0).build();
        WebSocketUtil.send(session, SendResponse.TYPE, sendResponse);

        // 创建转发的消息
        SendToUserRequest sendToUserRequest = SendToUserRequest.builder().msgId(message.getMsgId()).content(message.getContent()).build();
        // 广播发送
        WebSocketUtil.send(message.getToUser(), SendToUserRequest.TYPE, sendToUserRequest);
    }

    @Override
    public String getType() {
        return SendToOneRequest.TYPE;
    }

}
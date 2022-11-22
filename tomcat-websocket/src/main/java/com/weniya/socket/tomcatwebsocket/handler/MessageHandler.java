package com.weniya.socket.tomcatwebsocket.handler;// MessageHandler.java

import com.weniya.socket.tomcatwebsocket.message.Message;

import javax.websocket.Session;

/**
 * @author 温笙
 */
public interface MessageHandler<T extends Message> {

    /**
     * 执行处理消息
     *
     * @param session 会话
     * @param message 消息
     */
    void execute(Session session, T message);

    /**
     * @return 消息类型，即每个 Message 实现类上的 TYPE 静态字段
     */
    String getType();

}
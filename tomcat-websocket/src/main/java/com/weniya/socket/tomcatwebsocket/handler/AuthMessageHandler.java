package com.weniya.socket.tomcatwebsocket.handler;

import com.weniya.socket.tomcatwebsocket.message.AuthRequest;
import com.weniya.socket.tomcatwebsocket.message.AuthResponse;
import com.weniya.socket.tomcatwebsocket.message.UserJoinNoticeRequest;
import com.weniya.socket.tomcatwebsocket.util.WebSocketUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.websocket.Session;

@Component
public class AuthMessageHandler implements MessageHandler<AuthRequest> {

    @Override
    public void execute(Session session, AuthRequest message) {
        // 如果未传递 accessToken 
        if (StringUtils.isEmpty(message.getAccessToken())) {
            WebSocketUtil.send(session, AuthResponse.TYPE,
                    AuthResponse.builder().code(1).message("认证 accessToken 未传入").build());
            return;
        }

        // 添加到 WebSocketUtil 中
        WebSocketUtil.addSession(session, message.getAccessToken()); // 考虑到代码简化，我们先直接使用 accessToken 作为 User

        // 判断是否认证成功。这里，假装直接成功
        WebSocketUtil.send(session, AuthResponse.TYPE, AuthResponse.builder().code(0).build());

        // 通知所有人，某个人加入了。这个是可选逻辑，仅仅是为了演示
        // 考虑到代码简化，我们先直接使用 accessToken 作为 User
        WebSocketUtil.broadcast(UserJoinNoticeRequest.TYPE,
                UserJoinNoticeRequest.builder().nickname(message.getAccessToken()).build());
    }

    @Override
    public String getType() {
        return AuthRequest.TYPE;
    }

}
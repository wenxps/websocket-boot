package com.weniya.socket.tomcatwebsocket.message;

import lombok.Builder;
import lombok.Data;

/**
 * @author 温笙
 * 用户成功认证之后，会广播用户加入群聊的通知 Message
 */
@Data
@Builder
public class UserJoinNoticeRequest implements Message {

    public static final String TYPE = "USER_JOIN_NOTICE_REQUEST";

    /**
     * 昵称
     */
    private String nickname;

}
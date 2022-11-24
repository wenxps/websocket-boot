package com.weniya.chat.model;

import lombok.Data;

/**
 * @author 温笙
 */
@Data
public class Chat {

    private String to;
    private String from;
    private String content;
}
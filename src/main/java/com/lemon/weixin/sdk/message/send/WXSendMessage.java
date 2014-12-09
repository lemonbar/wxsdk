package com.lemon.weixin.sdk.message.send;

import lombok.Data;

/**
 * Created by lemon_bar on 14-12-2.
 */
@Data
public class WXSendMessage {
    private String touser;
    private String msgtype;

    public WXSendMessage(String touser, String msgtype) {
        this.touser = touser;
        this.msgtype = msgtype;
    }
}
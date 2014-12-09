package com.lemon.weixin.sdk.message.send.req;

import com.lemon.weixin.sdk.message.send.req.content.WXSendText;
import lombok.Data;

/**
 * Created by lemon_bar on 14-12-2.
 */
@Data
public class WXSendTextMessage extends WXSendMessage {
    private WXSendText text;

    public WXSendTextMessage(String touser, String content) {
        super(touser, "text");
        this.text = new WXSendText(content);
    }
}
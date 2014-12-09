package com.lemon.weixin.sdk.message.send.req.content;

import lombok.Data;

/**
 * Created by lemon_bar on 14-12-2.
 */
@Data
public class WXSendText {
    private String content;

    public WXSendText(String content) {
        this.content = content;
    }
}

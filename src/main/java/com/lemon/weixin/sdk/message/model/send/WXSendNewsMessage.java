package com.lemon.weixin.sdk.message.model.send;

import com.lemon.weixin.sdk.message.model.send.content.WXSendNews;
import lombok.Data;

/**
 * Created by limeng0402 on 14-12-4.
 */
@Data
public class WXSendNewsMessage extends WXSendMessage {
    private WXSendNews news;

    public WXSendNewsMessage(String touser, WXSendNews news) {
        super(touser, "news");
        this.news = news;
    }
}

package com.lemon.weixin.sdk.message.model.send;

import com.lemon.weixin.sdk.message.model.send.content.WXSendMedia;
import lombok.Data;

/**
 * Created by limeng0402 on 14-12-4.
 */
@Data
public class WXSendImageMessage extends WXSendMessage {
    private WXSendMedia image;

    public WXSendImageMessage(String touser, String mediaId) {
        super(touser, "image");
        this.image = new WXSendMedia(mediaId);
    }
}

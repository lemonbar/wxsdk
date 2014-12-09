package com.lemon.weixin.sdk.message.send.req.content;

import lombok.Data;

/**
 * Created by limeng0402 on 14-12-4.
 */
@Data
public class WXSendMedia {
    private String media_id;

    public WXSendMedia(String mediaId) {
        this.media_id = mediaId;
    }
}

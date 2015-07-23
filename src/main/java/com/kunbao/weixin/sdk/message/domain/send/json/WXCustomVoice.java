package com.kunbao.weixin.sdk.message.domain.send.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kunbao.weixin.sdk.message.domain.send.json.metadata.MediaContent;
import lombok.Getter;

/**
 * Created by lemon_bar on 15/7/23.
 */
@Getter
public class WXCustomVoice extends WXCustomMessage {
    @JsonProperty("voice")
    private MediaContent mediaContent;

    public WXCustomVoice(String toUser, String mediaId) {
        super(toUser, WXCustomMessageType.voice);
        this.mediaContent = new MediaContent(mediaId);
    }
}

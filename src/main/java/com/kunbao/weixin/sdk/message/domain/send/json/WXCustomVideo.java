package com.kunbao.weixin.sdk.message.domain.send.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kunbao.weixin.sdk.message.domain.send.json.metadata.VideoContent;
import lombok.Getter;

/**
 * Created by lemon_bar on 15/7/23.
 */
@Getter
public class WXCustomVideo extends WXCustomMessage {
    @JsonProperty("video")
    private VideoContent videoContent;

    public WXCustomVideo(String toUser, VideoContent videoContent) {
        super(toUser, WXCustomMessageType.video);
        this.videoContent = videoContent;
    }
}

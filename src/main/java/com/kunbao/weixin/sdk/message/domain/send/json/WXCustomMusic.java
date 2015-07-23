package com.kunbao.weixin.sdk.message.domain.send.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kunbao.weixin.sdk.message.domain.send.json.metadata.MusicContent;
import lombok.Getter;

/**
 * Created by lemon_bar on 15/7/23.
 */
@Getter
public class WXCustomMusic extends WXCustomMessage {
    @JsonProperty("music")
    private MusicContent musicContent;

    public WXCustomMusic(String toUser, MusicContent musicContent) {
        super(toUser, WXCustomMessageType.music);
        this.musicContent = musicContent;
    }
}

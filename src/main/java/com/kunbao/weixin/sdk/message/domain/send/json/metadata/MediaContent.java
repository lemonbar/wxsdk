package com.kunbao.weixin.sdk.message.domain.send.json.metadata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * Created by lemon_bar on 15/7/23.
 */
@Getter
public class MediaContent {
    @JsonProperty("media_id")
    private String mediaId;

    public MediaContent(String mediaId) {
        this.mediaId = mediaId;
    }
}

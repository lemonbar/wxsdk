package com.kunbao.weixin.sdk.message.domain.send.json.metadata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * "media_id":"MEDIA_ID",
 * "thumb_media_id":"MEDIA_ID",
 * "title":"TITLE",
 * "description":"DESCRIPTION"
 * Created by lemon_bar on 15/7/23.
 */
@Getter
public class VideoContent extends MediaContent {

    @JsonProperty("thumb_media_id")
    private String thumbMediaId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    public VideoContent(String mediaId, String thumbMediaId, String title, String description) {
        super(mediaId);
        this.thumbMediaId = thumbMediaId;
        this.title = title;
        this.description = description;
    }
}

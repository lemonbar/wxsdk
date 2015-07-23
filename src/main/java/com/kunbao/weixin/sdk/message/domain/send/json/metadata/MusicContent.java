package com.kunbao.weixin.sdk.message.domain.send.json.metadata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * "title":"MUSIC_TITLE",
 * "description":"MUSIC_DESCRIPTION",
 * "musicurl":"MUSIC_URL",
 * "hqmusicurl":"HQ_MUSIC_URL",
 * "thumb_media_id":"THUMB_MEDIA_ID"
 * Created by lemon_bar on 15/7/23.
 */
@Getter
public class MusicContent {
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("musicurl")
    private String musicUrl;
    @JsonProperty("hqmusicurl")
    private String hqMusicUrl;
    @JsonProperty("thumb_media_id")
    private String thumbMediaId;

    public MusicContent(String title, String description, String musicUrl, String hqMusicUrl, String thumbMediaId) {
        this.title = title;
        this.description = description;
        this.musicUrl = musicUrl;
        this.hqMusicUrl = hqMusicUrl;
        this.thumbMediaId = thumbMediaId;
    }
}

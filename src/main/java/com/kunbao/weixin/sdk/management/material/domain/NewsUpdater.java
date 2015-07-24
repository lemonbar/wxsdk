package com.kunbao.weixin.sdk.management.material.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * {
 * "media_id":MEDIA_ID,
 * "index":INDEX,
 * "articles": {
 * "title": TITLE,
 * "thumb_media_id": THUMB_MEDIA_ID,
 * "author": AUTHOR,
 * "digest": DIGEST,
 * "show_cover_pic": SHOW_COVER_PIC(0 / 1),
 * "content": CONTENT,
 * "content_source_url": CONTENT_SOURCE_URL
 * }
 * }
 * Created by lemon_bar on 15/7/24.
 */
@Getter
public class NewsUpdater {
    @JsonProperty("media_id")
    private String mediaId;
    @JsonProperty("index")
    private int index;
    @JsonProperty("articles")
    private NewsItem item;

    public NewsUpdater(String mediaId, int index, NewsItem item) {
        this.mediaId = mediaId;
        this.index = index;
        this.item = item;
    }
}

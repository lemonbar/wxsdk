package com.kunbao.weixin.sdk.management.material.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * [{
 * "title": TITLE,
 * "thumb_media_id": THUMB_MEDIA_ID,
 * "show_cover_pic": SHOW_COVER_PIC(0 / 1),
 * "author": AUTHOR,
 * "digest": DIGEST,
 * "content": CONTENT,
 * "url": URL,
 * "content_source_url": CONTETN_SOURCE_URL
 * },
 * //多图文消息会在此处有多篇文章
 * ]
 * Created by lemon_bar on 15/7/12.
 */
@Data
public class NewsItem {
    @JsonProperty("title")
    private String title;
    @JsonProperty("thumb_media_id")
    private String thumbMediaId;
    @JsonProperty("show_cover_pic")
    private boolean showCoverPic;
    @JsonProperty("author")
    private String author;
    @JsonProperty("digest")
    private String digest;
    @JsonProperty("content")
    private String content;
    @JsonProperty("url")
    private String url;
    @JsonProperty("content_source_url")
    private String contentSourceUrl;
}

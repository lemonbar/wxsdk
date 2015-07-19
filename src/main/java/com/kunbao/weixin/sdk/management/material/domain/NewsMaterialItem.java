package com.kunbao.weixin.sdk.management.material.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * "item": [{
 * "media_id": MEDIA_ID,
 * "content": {
 * "news_item": [{
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
 * },
 * Created by lemon_bar on 15/7/12.
 */
@Getter
public class NewsMaterialItem {
    @JsonProperty("media_id")
    private String mediaId;
    @JsonProperty("content")
    private NewsMaterialContent content;
}

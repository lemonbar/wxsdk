package com.kunbao.weixin.sdk.message.domain.send.json.metadata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * {
 * "title":"Happy Day",
 * "description":"Is Really A Happy Day",
 * "url":"URL",
 * "picurl":"PIC_URL"
 * },
 * Created by lemon_bar on 15/7/23.
 */
@Getter
public class NewsItemContent {
    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("url")
    private String url;

    @JsonProperty("picurl")
    private String picUrl;

    public NewsItemContent(String title, String description, String url, String picUrl) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.picUrl = picUrl;
    }
}

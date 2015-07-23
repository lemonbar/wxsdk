package com.kunbao.weixin.sdk.message.domain.send.json.metadata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

/**
 * "articles": [
 * {
 * "title":"Happy Day",
 * "description":"Is Really A Happy Day",
 * "url":"URL",
 * "picurl":"PIC_URL"
 * },
 * {
 * "title":"Happy Day",
 * "description":"Is Really A Happy Day",
 * "url":"URL",
 * "picurl":"PIC_URL"
 * }
 * ]
 * Created by lemon_bar on 15/7/23.
 */
@Getter
public class NewsContent {
    @JsonProperty("articles")
    private List<NewsItemContent> articles;

    public NewsContent(List<NewsItemContent> articles) {
        this.articles = articles;
    }

}

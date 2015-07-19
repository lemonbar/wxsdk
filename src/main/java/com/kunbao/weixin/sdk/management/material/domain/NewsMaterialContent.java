package com.kunbao.weixin.sdk.management.material.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

/**
 * "media_id": MEDIA_ID,
 * "content": {
 * "news_item": [{
 * Created by lemon_bar on 15/7/12.
 */
@Getter
public class NewsMaterialContent {
    @JsonProperty("news_item")
    private List<NewsItem> newsItem;
}

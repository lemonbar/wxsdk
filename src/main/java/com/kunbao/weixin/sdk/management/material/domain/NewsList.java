package com.kunbao.weixin.sdk.management.material.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by lemon_bar on 15/7/12.
 */
@Data
public class NewsList {
    @JsonProperty("articles")
    private List<NewsItem> newsItems;
}

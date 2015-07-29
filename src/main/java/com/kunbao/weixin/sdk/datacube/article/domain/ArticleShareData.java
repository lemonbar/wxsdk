package com.kunbao.weixin.sdk.datacube.article.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * {
 * "ref_date": "2014-12-07",
 * "share_scene": 1,
 * "share_count": 207,
 * "share_user": 11
 * },
 * Created by lemon_bar on 15/7/29.
 */
@Getter
public class ArticleShareData {
    @JsonProperty("ref_date")
    private String refDate;
    @JsonProperty("share_scene")
    private int shareScene;
    @JsonProperty("share_count")
    private int shareCount;
    @JsonProperty("share_user")
    private int shareUser;
}

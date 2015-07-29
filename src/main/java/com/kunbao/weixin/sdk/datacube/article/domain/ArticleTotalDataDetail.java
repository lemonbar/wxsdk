package com.kunbao.weixin.sdk.datacube.article.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * {
 * "stat_date": "2014-12-14",
 * "target_user": 261917,
 * "int_page_read_user": 23676,
 * "int_page_read_count": 25615,
 * "ori_page_read_user": 29,
 * "ori_page_read_count": 34,
 * "share_user": 122,
 * "share_count": 994,
 * "add_to_fav_user": 1,
 * "add_to_fav_count": 3
 * },
 * Created by lemon_bar on 15/7/29.
 */
@Getter
public class ArticleTotalDataDetail {
    @JsonProperty("stat_date")
    private String statDate;
    @JsonProperty("target_user")
    private long targetUserCount;
    @JsonProperty("int_page_read_user")
    private long readUserCount;
    @JsonProperty("int_page_read_count")
    private long readCount;
    @JsonProperty("ori_page_read_user")
    private long readOriUserCount;
    @JsonProperty("ori_page_read_count")
    private long readOriCount;
    @JsonProperty("share_user")
    private long shareUserCount;
    @JsonProperty("share_count")
    private long shareCount;
    @JsonProperty("add_to_fav_user")
    private long favUserCount;
    @JsonProperty("add_to_fav_count")
    private long favCount;
}

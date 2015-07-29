package com.kunbao.weixin.sdk.datacube.article.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * {
 * "ref_date": "2014-12-07",
 * "int_page_read_user": 45524,
 * "int_page_read_count": 48796,
 * "ori_page_read_user": 11,
 * "ori_page_read_count": 35,
 * "share_user": 11,
 * "share_count": 276,
 * "add_to_fav_user": 5,
 * "add_to_fav_count": 15
 * },
 * Created by lemon_bar on 15/7/29.
 */
@Getter
public class UserReadData {
    @JsonProperty("ref_date")
    private String refDate;
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

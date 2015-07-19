package com.kunbao.weixin.sdk.management.material.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * "item": [{
 * "media_id": MEDIA_ID,
 * "name": NAME,
 * "update_time": UPDATE_TIME,
 * "url":URL
 * },
 * //可能会有多个素材
 * ]
 * Created by lemon_bar on 15/7/12.
 */
@Getter
public class CommonMaterialItem {
    @JsonProperty("media_id")
    private String mediaId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("update_time")
    private String updateTime;
    @JsonProperty("url")
    private String url;
}

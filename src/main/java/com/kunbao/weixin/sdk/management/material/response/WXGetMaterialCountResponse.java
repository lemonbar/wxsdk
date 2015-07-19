package com.kunbao.weixin.sdk.management.material.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import lombok.Getter;

/**
 * {
 * "voice_count":COUNT,
 * "video_count":COUNT,
 * "image_count":COUNT,
 * "news_count":COUNT
 * }
 * Created by lemon_bar on 15/7/12.
 */
@Getter
public class WXGetMaterialCountResponse extends WXJsonResponse {
    @JsonProperty("voice_count")
    private int voiceCount;
    @JsonProperty("video_count")
    private int videoCount;
    @JsonProperty("image_count")
    private int imageCount;
    @JsonProperty("news_count")
    private int newsCount;
}

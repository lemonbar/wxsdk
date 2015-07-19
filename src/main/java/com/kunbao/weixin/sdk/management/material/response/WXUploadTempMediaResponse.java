package com.kunbao.weixin.sdk.management.material.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import com.kunbao.weixin.sdk.management.material.domain.constant.MediaType;
import lombok.Getter;

/**
 * {"type":"TYPE","media_id":"MEDIA_ID","created_at":123456789}
 * Created by jiang on 2015/7/12.
 */
@Getter
public class WXUploadTempMediaResponse extends WXJsonResponse {
    @JsonProperty("type")
    private MediaType mediaType;
    @JsonProperty("media_id")
    private String mediaId;
    @JsonProperty("created_at")
    private long createdAt;
}

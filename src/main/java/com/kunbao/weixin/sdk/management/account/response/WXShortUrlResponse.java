package com.kunbao.weixin.sdk.management.account.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import lombok.Getter;

/**
 * Created by lemon_bar on 15/7/10.
 */
@Getter
public class WXShortUrlResponse extends WXJsonResponse {
    @JsonProperty("short_url")
    private String shortUrl;
}

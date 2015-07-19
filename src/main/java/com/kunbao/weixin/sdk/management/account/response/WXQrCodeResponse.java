package com.kunbao.weixin.sdk.management.account.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import lombok.Getter;

/**
 * {"ticket":"gQH47joAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL2taZ2Z3TVRtNzJXV1Brb3ZhYmJJAAIEZ23sUwMEmm3sUw==",
 * "expire_seconds":60,
 * "url":"http:\/\/weixin.qq.com\/q\/kZgfwMTm72WWPkovabbI"}
 * Created by lemon_bar on 15/7/10.
 */
@Getter
public class WXQrCodeResponse extends WXJsonResponse {
    @JsonProperty("ticket")
    private String ticket;

    @JsonProperty("expire_seconds")
    private long expireSeconds;

    @JsonProperty("url")
    private String url;

}

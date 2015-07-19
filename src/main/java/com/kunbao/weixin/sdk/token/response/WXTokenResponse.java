package com.kunbao.weixin.sdk.token.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import lombok.Getter;

/**
 * Created by lemon_bar on 15/7/7.
 */
@Getter
public class WXTokenResponse extends WXJsonResponse {
    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private long expires;

    public WXTokenResponse() {
        super();
    }
}

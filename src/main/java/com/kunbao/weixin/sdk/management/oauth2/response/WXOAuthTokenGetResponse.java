package com.kunbao.weixin.sdk.management.oauth2.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import lombok.Getter;

/**
 * Created by baylor on 15/7/25.
 */
@Getter
public class WXOAuthTokenGetResponse extends WXJsonResponse {
    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private long expires;

    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty("openid")
    private String openId;

    @JsonProperty("unionid")
    private String unionId;

    @JsonProperty("scope")
    private String scope;
}

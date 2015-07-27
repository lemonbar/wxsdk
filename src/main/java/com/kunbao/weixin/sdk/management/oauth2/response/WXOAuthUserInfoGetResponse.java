package com.kunbao.weixin.sdk.management.oauth2.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import lombok.Getter;

/**
 * Created by baylor on 15/7/25.
 */
@Getter
public class WXOAuthUserInfoGetResponse extends WXJsonResponse {
    @JsonProperty("openid")
    private String openId;

    @JsonProperty("nickname")
    private String nickName;

    @JsonProperty("sex")
    private String sex;

    @JsonProperty("province")
    private String province;

    @JsonProperty("city")
    private String city;

    @JsonProperty("country")
    private String country;

    @JsonProperty("headimgurl")
    private String headImgUrl;

    @JsonProperty("privilege")
    private String privilege;

    @JsonProperty("unionid")
    private String unionId;

    public WXOAuthUserInfoGetResponse() {
        super();
    }
}

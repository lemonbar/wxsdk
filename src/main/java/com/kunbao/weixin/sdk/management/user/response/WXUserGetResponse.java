package com.kunbao.weixin.sdk.management.user.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import com.kunbao.weixin.sdk.management.user.domain.WXOpenIdList;
import lombok.Getter;

/**
 * {"total":2,"count":2,"data":{"openid":["","OPENID1","OPENID2"]},"next_openid":"NEXT_OPENID"}
 * Created by lemon_bar on 15/7/22.
 */
@Getter
public class WXUserGetResponse extends WXJsonResponse {
    @JsonProperty("total")
    private long total;

    @JsonProperty("count")
    private int count;

    @JsonProperty("data")
    private WXOpenIdList openIdList;

    @JsonProperty("next_openid")
    private String nextOpenId;
}

package com.kunbao.weixin.sdk.datacube.message.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import com.kunbao.weixin.sdk.datacube.message.domain.UpstreamMsgDistData;
import lombok.Getter;

import java.util.List;

/**
 * Created by lemon_bar on 15/7/29.
 */
@Getter
public class WXUpstreamMsgDistGetResponse extends WXJsonResponse {
    @JsonProperty("list")
    private List<UpstreamMsgDistData> upstreamMsgDistData;
}

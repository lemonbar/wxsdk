package com.kunbao.weixin.sdk.datacube.wxinterface.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import com.kunbao.weixin.sdk.datacube.wxinterface.domain.InterfaceData;
import lombok.Getter;

import java.util.List;

/**
 * Created by lemon_bar on 15/7/29.
 */
@Getter
public class WXInterfaceSummaryGetResponse extends WXJsonResponse {
    @JsonProperty("list")
    private List<InterfaceData> interfaceData;
}

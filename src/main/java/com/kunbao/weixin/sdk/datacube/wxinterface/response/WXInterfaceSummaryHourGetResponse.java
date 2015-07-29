package com.kunbao.weixin.sdk.datacube.wxinterface.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import com.kunbao.weixin.sdk.datacube.wxinterface.domain.InterfaceHourData;
import lombok.Getter;

import java.util.List;

/**
 * "ref_hour": 0,
 * Created by lemon_bar on 15/7/29.
 */
@Getter
public class WXInterfaceSummaryHourGetResponse extends WXJsonResponse {
    @JsonProperty("list")
    private List<InterfaceHourData> interfaceHourData;
}

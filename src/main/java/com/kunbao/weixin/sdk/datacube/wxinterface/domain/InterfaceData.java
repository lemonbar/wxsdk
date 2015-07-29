package com.kunbao.weixin.sdk.datacube.wxinterface.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * {
 * "ref_date": "2014-12-07",
 * "callback_count": 36974,
 * "fail_count": 67,
 * "total_time_cost": 14994291,
 * "max_time_cost": 5044
 * }
 * Created by lemon_bar on 15/7/29.
 */
@Getter
public class InterfaceData {
    @JsonProperty("ref_date")
    private String refDate;
    @JsonProperty("callback_count")
    private long callbackCount;
    @JsonProperty("fail_count")
    private long failCount;
    @JsonProperty("total_time_cost")
    private long totalTimeCost;
    @JsonProperty("max_time_cost")
    private long maxTimeCost;
}

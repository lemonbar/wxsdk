package com.kunbao.weixin.sdk.datacube.message.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * "ref_hour": 0,
 * Created by lemon_bar on 15/7/29.
 */
@Getter
public class UpstreamMsgHourData extends UpstreamMsgData {
    @JsonProperty("ref_hour")
    private int refHour;
}

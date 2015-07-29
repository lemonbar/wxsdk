package com.kunbao.weixin.sdk.datacube.wxinterface.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * Created by lemon_bar on 15/7/29.
 */
@Getter
public class InterfaceHourData extends InterfaceData {
    @JsonProperty("ref_hour")
    private int refHour;
}

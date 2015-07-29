package com.kunbao.weixin.sdk.datacube.message.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * {
 * "ref_date": "2014-12-07",
 * "count_interval": 1,
 * "msg_user": 246
 * }
 * Created by lemon_bar on 15/7/29.
 */
@Getter
public class UpstreamMsgDistData {
    @JsonProperty("ref_date")
    private String refDate;
    @JsonProperty("count_interval")
    private int countInterval;
    @JsonProperty("msg_user")
    private int msgUser;
}

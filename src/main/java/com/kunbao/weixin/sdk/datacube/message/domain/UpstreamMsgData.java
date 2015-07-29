package com.kunbao.weixin.sdk.datacube.message.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * {
 * "ref_date": "2014-12-07",
 * "msg_type": 1,
 * "msg_user": 282,
 * "msg_count": 817
 * }
 * Created by lemon_bar on 15/7/29.
 */
@Getter
public class UpstreamMsgData {
    @JsonProperty("ref_date")
    private String refDate;
    @JsonProperty("msg_type")
    private int msgType;
    @JsonProperty("msg_user")
    private long msgUserCount;
    @JsonProperty("msg_count")
    private long msgCount;
}

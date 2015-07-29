package com.kunbao.weixin.sdk.datacube.user.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * {
 * "ref_date": "2014-12-07",
 * "cumulate_user": 1217056
 * },
 * Created by lemon_bar on 15/7/29.
 */
@Getter
public class UserCumulateItem {
    @JsonProperty("ref_date")
    private String refDate;
    @JsonProperty("cumulate_user")
    private long userCount;
}

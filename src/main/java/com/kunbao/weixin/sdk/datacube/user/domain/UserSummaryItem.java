package com.kunbao.weixin.sdk.datacube.user.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * "ref_date": "2014-12-07",
 * "user_source": 0,
 * "new_user": 0,
 * "cancel_user": 0
 * Created by lemon_bar on 15/7/27.
 */
@Getter
public class UserSummaryItem {
    @JsonProperty("ref_date")
    private String refDate;
    @JsonProperty("user_source")
    private int userSource;
    @JsonProperty("new_user")
    private int newUser;
    @JsonProperty("cancel_user")
    private int cancelUser;
}

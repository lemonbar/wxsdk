package com.kunbao.weixin.sdk.management.user.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * Created by lemon_bar on 15/7/24.
 */
@Getter
public class WXUserMove {
    @JsonProperty("openid")
    private String openId;
    @JsonProperty("to_groupid")
    private int groupId;

    public WXUserMove(String openId, int groupId) {
        this.openId = openId;
        this.groupId = groupId;
    }

    protected WXUserMove() {
    }
}

package com.kunbao.weixin.sdk.management.user.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * Created by lemon_bar on 15/7/23.
 */
@Getter
public class WXOpenId {
    @JsonProperty("openid")
    private String openId;

    protected WXOpenId() {
    }

    public WXOpenId(String openId) {
        this.openId = openId;
    }
}

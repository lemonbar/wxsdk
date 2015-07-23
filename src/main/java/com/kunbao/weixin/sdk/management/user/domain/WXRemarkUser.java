package com.kunbao.weixin.sdk.management.user.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * {
 * "openid":"oDF3iY9ffA-hqb2vVvbr7qxf6A0Q",
 * "remark":"pangzi"
 * }
 * Created by lemon_bar on 15/7/24.
 */
@Getter
public class WXRemarkUser {
    @JsonProperty("openid")
    private String openId;
    @JsonProperty("remark")
    private String remark;

    public WXRemarkUser(String openId, String remark) {
        this.openId = openId;
        this.remark = remark;
    }
}

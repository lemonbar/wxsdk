package com.kunbao.weixin.sdk.management.user.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * {
 * "openid": "otvxTs4dckWG7imySrJd6jSi0CWE",
 * "lang": "zh-CN"
 * },
 * Created by lemon_bar on 15/7/24.
 */
@Getter
public class WXUser {
    @JsonProperty("openid")
    private String openId;
    @JsonProperty("lang")
    private WXLang lang;

    public WXUser(String openId, WXLang lang) {
        this.openId = openId;
        this.lang = lang;
    }
}

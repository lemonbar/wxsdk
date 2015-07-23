package com.kunbao.weixin.sdk.message.domain.send.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * {
 * "touser":"OPENID",
 * "msgtype":"text",
 * Created by lemon_bar on 15/7/23.
 */
@Getter
public class WXCustomMessage {
    @JsonProperty("touser")
    private String toUser;

    @JsonProperty("msgtype")
    private WXCustomMessageType type;

    public WXCustomMessage(String toUser, WXCustomMessageType type) {
        this.toUser = toUser;
        this.type = type;
    }
}

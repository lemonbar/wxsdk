package com.kunbao.weixin.sdk.message.domain.send.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kunbao.weixin.sdk.message.domain.send.json.metadata.TextContent;
import lombok.Getter;

/**
 * Created by lemon_bar on 15/7/23.
 */
@Getter
public class WXCustomText extends WXCustomMessage {
    @JsonProperty("text")
    private TextContent textContent;

    public WXCustomText(String toUser, String content) {
        super(toUser, WXCustomMessageType.text);
        this.textContent = new TextContent(content);
    }
}

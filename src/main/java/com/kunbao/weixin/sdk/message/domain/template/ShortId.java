package com.kunbao.weixin.sdk.message.domain.template;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * "template_id_short":"TM00015"
 * Created by lemon_bar on 15/7/30.
 */
public class ShortId {
    @JsonProperty("template_id_short")
    private String shortId;

    public ShortId(String shortId) {
        this.shortId = shortId;
    }
}

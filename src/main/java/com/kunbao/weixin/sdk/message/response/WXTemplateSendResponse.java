package com.kunbao.weixin.sdk.message.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import lombok.Getter;

/**
 * {
 * "errcode":0,
 * "errmsg":"ok",
 * "msgid":200228332
 * }
 * Created by lemon_bar on 15/7/30.
 */
@Getter
public class WXTemplateSendResponse extends WXJsonResponse {
    @JsonProperty("msgid")
    private String msgId;
}

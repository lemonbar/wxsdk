package com.kunbao.weixin.sdk.message.domain.template;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * {
 * "touser":"OPENID",
 * "template_id":"ngqIpbwh8bUfcSsECmogfXcV14J0tQlEpBO27izEYtY",
 * "url":"http://weixin.qq.com/download",
 * "topcolor":"#FF0000",
 * "data":{
 * "first": {
 * "value":"恭喜你购买成功！",
 * "color":"#173177"
 * },
 * "keynote1":{
 * "value":"巧克力",
 * "color":"#173177"
 * },
 * ...
 * }
 * }
 * Created by lemon_bar on 15/7/30.
 */
public class MessageInfo {
    @JsonProperty("touser")
    private String toUserOpenId;
    @JsonProperty("template_id")
    private String templateId;
    @JsonProperty("url")
    private String url;
    @JsonProperty("topcolor")
    private String topColor;
    @JsonProperty("data")
    private Map<String, ItemValue> data;

    public MessageInfo(String toUserOpenId, String templateId, String url, String topColor) {
        this.toUserOpenId = toUserOpenId;
        this.templateId = templateId;
        this.url = url;
        this.topColor = topColor;
        this.data = new HashMap<String, ItemValue>();
    }

    public void addItem(String key, ItemValue value) {
        this.data.put(key, value);
    }
}

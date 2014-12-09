package com.lemon.weixin.sdk.message.send;

import com.lemon.weixin.sdk.message.send.content.WXSendTemplateItem;
import lombok.Data;

import java.util.Map;

/**
 * Created by limeng0402 on 14-12-7.
 */
@Data
public class WXSendTemplateMessage {
    private String touser;
    private String template_id;
    private String url;
    private String topcolor;
    private Map<String, WXSendTemplateItem> data;

    public WXSendTemplateMessage(String touser, String template_id, String url, String topcolor, Map<String, WXSendTemplateItem> data) {
        this.touser = touser;
        this.template_id = template_id;
        this.url = url;
        this.topcolor = topcolor;
        this.data = data;
    }
}
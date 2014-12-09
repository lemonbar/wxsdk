package com.lemon.weixin.sdk.message.send.content;

import lombok.Data;

/**
 * Created by limeng0402 on 14-12-7.
 */
@Data
public class WXSendTemplateItem {
    private String value;
    private String color;

    public WXSendTemplateItem(String value, String color) {
        this.value = value;
        this.color = color;
    }
}
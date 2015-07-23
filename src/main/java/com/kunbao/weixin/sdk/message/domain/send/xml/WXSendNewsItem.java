package com.kunbao.weixin.sdk.message.domain.send.xml;

import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by lemon_bar on 15/7/23.
 */
@Getter
@ToString(callSuper = true)
public class WXSendNewsItem {
    @XmlElement(name = "item")
    private WXSendNewsMedia wxSendNewsMedia;

    protected WXSendNewsItem() {
    }

    public WXSendNewsItem(String title, String description, String picUrl, String url) {
        this.wxSendNewsMedia = new WXSendNewsMedia(title, description, picUrl, url);
    }
}

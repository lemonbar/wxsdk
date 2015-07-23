package com.kunbao.weixin.sdk.message.domain.send.xml;

import com.kunbao.weixin.sdk.util.xml.XMLCDataAdapter;
import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by lemon_bar on 15/7/23.
 */
@Getter
@ToString(callSuper = true)
public class WXSendNewsMedia {
    @XmlJavaTypeAdapter(XMLCDataAdapter.class)
    @XmlElement(name = "Title")
    private String title;

    @XmlJavaTypeAdapter(XMLCDataAdapter.class)
    @XmlElement(name = "Description")
    private String description;

    @XmlJavaTypeAdapter(XMLCDataAdapter.class)
    @XmlElement(name = "PicUrl")
    private String picUrl;

    @XmlJavaTypeAdapter(XMLCDataAdapter.class)
    @XmlElement(name = "Url")
    private String url;

    protected WXSendNewsMedia(){}

    public WXSendNewsMedia(String title, String description, String picUrl, String url) {
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
        this.url = url;
    }
}

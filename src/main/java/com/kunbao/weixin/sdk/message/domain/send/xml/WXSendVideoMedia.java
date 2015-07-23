package com.kunbao.weixin.sdk.message.domain.send.xml;

import com.kunbao.weixin.sdk.util.xml.XMLCDataAdapter;
import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * <Video>
 * <MediaId><![CDATA[media_id]]></MediaId>
 * <Title><![CDATA[title]]></Title>
 * <Description><![CDATA[description]]></Description>
 * </Video>
 * Created by lemon_bar on 15/7/23.
 */
@Getter
public class WXSendVideoMedia extends WXSendMedia {
    @XmlJavaTypeAdapter(XMLCDataAdapter.class)
    @XmlElement(name = "Title")
    private String title;

    @XmlJavaTypeAdapter(XMLCDataAdapter.class)
    @XmlElement(name = "Description")
    private String description;

    protected WXSendVideoMedia() {
        super();
    }

    public WXSendVideoMedia(String mediaId) {
        super(mediaId);
    }

    public WXSendVideoMedia(String mediaId, String title, String description) {
        this(mediaId);
        this.title = title;
        this.description = description;
    }
}

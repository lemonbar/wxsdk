package com.kunbao.weixin.sdk.message.domain.send.xml;

import com.kunbao.weixin.sdk.util.xml.XMLCDataAdapter;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by lemon_bar on 15/7/17.
 */
@Getter
public class WXSendMedia {
    @XmlJavaTypeAdapter(XMLCDataAdapter.class)
    @XmlElement(name = "MediaId")
    @Setter(AccessLevel.PRIVATE)
    private String mediaId;

    protected WXSendMedia() {
    }

    public WXSendMedia(String mediaId) {
        this.mediaId = mediaId;
    }
}

package com.kunbao.weixin.sdk.message.domain.received.common;

import com.kunbao.weixin.sdk.util.xml.XMLCDataAdapter;
import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Getter
@ToString(callSuper = true)
@XmlRootElement(name = "xml")
public class WXReceivedVideo extends WXReceivedMessage {
    @XmlJavaTypeAdapter(XMLCDataAdapter.class)
    @XmlElement(name = "MediaId")
    private String mediaId;

    @XmlJavaTypeAdapter(XMLCDataAdapter.class)
    @XmlElement(name = "ThumbMediaId")
    private String thumbMediaId;
}

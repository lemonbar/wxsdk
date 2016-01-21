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
public class WXReceivedLocation extends WXReceivedMessage {
    @XmlElement(name = "Location_X")
    private double locationX;

    @XmlElement(name = "Location_Y")
    private double locationY;

    @XmlElement(name = "Scale")
    private double scale;

    @XmlJavaTypeAdapter(XMLCDataAdapter.class)
    @XmlElement(name = "Label")
    private String lable;
}

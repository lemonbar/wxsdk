package com.lemon.weixin.sdk.message.receive.resp;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by limeng0402 on 14-12-10.
 */
@XmlRootElement(name = "xml")
@Getter
public class WXReceiveResponseVideoMessage extends WXReceiveResponseMessage {
    @XmlElement
    private WXReceiveResponseVideo Video;
}

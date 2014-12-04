package com.lemon.weixin.sdk.message.model.receive;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by lemon_bar on 14-12-2.
 */
@XmlRootElement(name = "xml")
public class WXReceiveTextMessage extends WXReceiveMessage {
    @XmlElement
    public String Content;
}
package com.lemon.weixin.sdk.message.receive;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by lemon_bar on 14-12-2.
 */
public class WXReceiveMessage {
    @XmlElement
    public String ToUserName;
    @XmlElement
    public String FromUserName;
    @XmlElement
    public Long CreateTime;
    @XmlElement
    public String MsgType;
    @XmlElement
    public Long MsgId;
}

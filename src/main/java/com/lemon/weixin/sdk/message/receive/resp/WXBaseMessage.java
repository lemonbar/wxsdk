package com.lemon.weixin.sdk.message.receive.resp;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by lemon_bar on 2014/12/9.
 */
@Getter
public class WXBaseMessage {
    //接收方帐号（收到的OpenID）
    @XmlElement
    private String ToUserName;
    //开发者微信号
    @XmlElement
    private String FromUserName;
    //消息创建时间 （整型）
    @XmlElement
    private long CreateTime;
    //消息类型
    @XmlElement
    private String MsgType;
}
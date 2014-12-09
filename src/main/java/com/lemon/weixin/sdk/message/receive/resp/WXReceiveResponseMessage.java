package com.lemon.weixin.sdk.message.receive.resp;

import com.lemon.weixin.sdk.util.WXCDataAdapter;
import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by lemon_bar on 2014/12/9.
 */
@Getter
public class WXReceiveResponseMessage {
    //接收方帐号（收到的OpenID）
    @XmlJavaTypeAdapter(WXCDataAdapter.class)
    @XmlElement(required = true)
    private String ToUserName;
    //开发者微信号
    @XmlJavaTypeAdapter(WXCDataAdapter.class)
    private String FromUserName;
    //消息创建时间 （整型）
    @XmlElement
    private long CreateTime;
    //消息类型
    @XmlJavaTypeAdapter(WXCDataAdapter.class)
    private String MsgType;
}
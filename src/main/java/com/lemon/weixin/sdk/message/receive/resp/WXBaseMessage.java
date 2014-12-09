package com.lemon.weixin.sdk.message.receive.resp;

import com.lemon.weixin.sdk.util.WXCDataAdapter;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by lemon_bar on 2014/12/9.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class WXBaseMessage {
    //接收方帐号（收到的OpenID）
//    @XmlElement
    @XmlJavaTypeAdapter(WXCDataAdapter.class)
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
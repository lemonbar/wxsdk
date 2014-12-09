package com.lemon.weixin.sdk.message.receive.req;

import com.lemon.weixin.sdk.util.WXCDataAdapter;
import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by lemon_bar on 2014/12/9.
 */
@Getter
public class WXReceiveRequestMessage {
    //开发者微信号
    @XmlJavaTypeAdapter(WXCDataAdapter.class)
    private String ToUserName;
    //发送方帐号（一个OpenID）
    @XmlJavaTypeAdapter(WXCDataAdapter.class)
    private String FromUserName;
    //消息创建时间（整型）
    @XmlElement
    private long CreateTime;
    //消息类型
    @XmlJavaTypeAdapter(WXCDataAdapter.class)
    private String MsgType;
    //消息id，64位整型
    @XmlElement
    private long MsgId;
}



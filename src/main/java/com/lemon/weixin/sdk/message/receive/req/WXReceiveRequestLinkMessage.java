package com.lemon.weixin.sdk.message.receive.req;

import com.lemon.weixin.sdk.util.WXCDataAdapter;
import lombok.Getter;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by lemon_bar on 2014/12/9.
 */
@XmlRootElement(name = "xml")
@Getter
public class WXReceiveRequestLinkMessage extends WXReceiveRequestMessage {
    //消息标题
    @XmlJavaTypeAdapter(WXCDataAdapter.class)
    private String Title;
    //消息描述
    @XmlJavaTypeAdapter(WXCDataAdapter.class)
    private String Description;
    //消息链接
    @XmlJavaTypeAdapter(WXCDataAdapter.class)
    private String Url;
}
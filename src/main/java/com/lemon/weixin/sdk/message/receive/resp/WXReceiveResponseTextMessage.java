package com.lemon.weixin.sdk.message.receive.resp;

import com.lemon.weixin.sdk.util.WXCDataAdapter;
import lombok.Getter;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by lemon_bar on 2014/12/9.
 */
@XmlRootElement(name = "xml")
@Getter
public class WXReceiveResponseTextMessage extends WXReceiveResponseMessage {
    //回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
    @XmlJavaTypeAdapter(WXCDataAdapter.class)
    private String Content;
}

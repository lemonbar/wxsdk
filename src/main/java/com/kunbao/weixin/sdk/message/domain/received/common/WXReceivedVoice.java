package com.kunbao.weixin.sdk.message.domain.received.common;

import com.kunbao.weixin.sdk.util.xml.XMLCDataAdapter;
import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 开通语音识别后，用户每次发送语音给公众号时，微信会在推送的语音消息XML数据包中，
 * 增加一个Recongnition字段（注：由于客户端缓存，开发者开启或者关闭语音识别功能，
 * 对新关注者立刻生效，对已关注用户需要24小时生效。开发者可以重新关注此帐号进行测试）
 * Created by lemon_bar on 15/7/6.
 */
@Getter
@ToString(callSuper = true)
@XmlRootElement(name = "xml")
public class WXReceivedVoice extends WXReceivedMessage {
    @XmlJavaTypeAdapter(XMLCDataAdapter.class)
    @XmlElement(name = "MediaId")
    private String mediaId;

    @XmlJavaTypeAdapter(XMLCDataAdapter.class)
    @XmlElement(name = "Format")
    private String format;

    @XmlJavaTypeAdapter(XMLCDataAdapter.class)
    @XmlElement(name = "Recognition")
    private String recognition;
}

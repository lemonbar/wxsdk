package com.kunbao.weixin.sdk.message.domain.send.xml;

import com.kunbao.weixin.sdk.message.domain.base.WXMessageBase;
import com.kunbao.weixin.sdk.message.domain.constant.WXMessageType;
import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by lemon_bar on 15/7/23.
 */
@Getter
@ToString(callSuper = true)
@XmlRootElement(name = "xml")
public class WXSendVoice extends WXMessageBase {
    @XmlElement(name = "Voice")
    private WXSendMedia voice;

    public WXSendVoice() {
    }

    public WXSendVoice(String fromUser, String toUser, String mediaId) {
        super(fromUser, toUser, WXMessageType.voice.toString());
        this.voice = new WXSendMedia(mediaId);
    }
}

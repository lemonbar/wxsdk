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
public class WXSendVideo extends WXMessageBase {
    @XmlElement(name = "Video")
    private WXSendVideoMedia video;

    protected WXSendVideo() {
        super();
    }

    public WXSendVideo(String fromUser, String toUser, WXSendVideoMedia videoMedia) {
        super(fromUser, toUser, WXMessageType.video.toString());
        this.video = videoMedia;
    }
}

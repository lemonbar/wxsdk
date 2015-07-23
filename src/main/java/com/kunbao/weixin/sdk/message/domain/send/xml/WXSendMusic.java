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
public class WXSendMusic extends WXMessageBase {
    @XmlElement(name = "Music")
    private WXSendMusicMedia musicMedia;

    protected WXSendMusic() {
        super();
    }

    public WXSendMusic(String fromUser, String toUser, WXSendMusicMedia musicMedia) {
        super(fromUser, toUser, WXMessageType.video.toString());
        this.musicMedia = musicMedia;
    }
}

package com.kunbao.weixin.sdk.message.domain.send.xml;

import com.kunbao.weixin.sdk.util.xml.XMLCDataAdapter;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by lemon_bar on 15/7/23.
 */
@Getter
public class WXSendMusicMedia {
    @XmlJavaTypeAdapter(XMLCDataAdapter.class)
    @XmlElement(name = "Title")
    private String title;

    @XmlJavaTypeAdapter(XMLCDataAdapter.class)
    @XmlElement(name = "Description")
    private String description;

    @XmlJavaTypeAdapter(XMLCDataAdapter.class)
    @XmlElement(name = "MusicUrl")
    private String musicUrl;

    @XmlJavaTypeAdapter(XMLCDataAdapter.class)
    @XmlElement(name = "HQMusicUrl")
    private String hqMusicUrl;

    @XmlJavaTypeAdapter(XMLCDataAdapter.class)
    @XmlElement(name = "ThumbMediaId")
    @Setter(AccessLevel.PRIVATE)
    private String thumbMediaId;

    protected WXSendMusicMedia() {
    }

    public WXSendMusicMedia(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public WXSendMusicMedia(String thumbMediaId, String title, String description, String musicUrl, String hqMusicUrl) {
        this(thumbMediaId);
        this.title = title;
        this.description = description;
        this.musicUrl = musicUrl;
        this.hqMusicUrl = hqMusicUrl;
    }
}

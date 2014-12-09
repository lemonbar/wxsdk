package com.lemon.weixin.sdk.message.receive.resp;

import com.lemon.weixin.sdk.util.WXCDataAdapter;
import lombok.Getter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by limeng0402 on 14-12-10.
 */
@Getter
public class WXReceiveResponseMusic {
    @XmlJavaTypeAdapter(WXCDataAdapter.class)
    private String Title;
    @XmlJavaTypeAdapter(WXCDataAdapter.class)
    private String Description;
    @XmlJavaTypeAdapter(WXCDataAdapter.class)
    private String MusicUrl;
    @XmlJavaTypeAdapter(WXCDataAdapter.class)
    private String HQMusicUrl;
    @XmlJavaTypeAdapter(WXCDataAdapter.class)
    private String ThumbMediaId;
}
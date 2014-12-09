package com.lemon.weixin.sdk.message.receive.resp;

import com.lemon.weixin.sdk.util.WXCDataAdapter;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by lemon_bar on 2014/12/9.
 */
@XmlRootElement
public class WXReceiveResponseArticle {
    @XmlJavaTypeAdapter(WXCDataAdapter.class)
    private String Title;
    @XmlJavaTypeAdapter(WXCDataAdapter.class)
    private String Description;
    @XmlJavaTypeAdapter(WXCDataAdapter.class)
    private String PicUrl;
    @XmlJavaTypeAdapter(WXCDataAdapter.class)
    private String Url;
}
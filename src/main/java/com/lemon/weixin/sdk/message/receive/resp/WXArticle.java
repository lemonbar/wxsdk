package com.lemon.weixin.sdk.message.receive.resp;

import com.lemon.weixin.sdk.util.WXCDataAdapter;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by lemon_bar on 2014/12/9.
 */
@XmlRootElement(name = "item")
public class WXArticle {
    @XmlJavaTypeAdapter(WXCDataAdapter.class)
    private String Title;
    @XmlJavaTypeAdapter(WXCDataAdapter.class)
    private String Description;
    @XmlJavaTypeAdapter(WXCDataAdapter.class)
    private String PicUrl;
    @XmlJavaTypeAdapter(WXCDataAdapter.class)
    private String Url;
}
package com.lemon.weixin.sdk.message.receive.resp;

import com.lemon.weixin.sdk.util.WXCDataAdapter;
import lombok.Getter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by limeng0402 on 14-12-10.
 */
@Getter
public class WXReceiveResponseVideo extends WXReceiveResponseMedia {
    //视频消息的标题
    @XmlJavaTypeAdapter(WXCDataAdapter.class)
    private String Title;
    //视频消息的描述
    @XmlJavaTypeAdapter(WXCDataAdapter.class)
    private String Description;
}
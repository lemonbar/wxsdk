package com.lemon.weixin.sdk.message.receive.resp;

import com.lemon.weixin.sdk.util.WXCDataAdapter;
import lombok.Getter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by lemon_bar on 2014/12/9.
 */
@Getter
public class WXReceiveResponseMedia {
    //通过上传多媒体文件，得到的id
    @XmlJavaTypeAdapter(WXCDataAdapter.class)
    private String MediaId;
}
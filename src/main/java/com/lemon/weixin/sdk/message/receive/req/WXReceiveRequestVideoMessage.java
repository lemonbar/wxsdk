package com.lemon.weixin.sdk.message.receive.req;

import com.lemon.weixin.sdk.util.WXCDataAdapter;
import lombok.Getter;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by lemon_bar on 2014/12/9.
 */
@XmlRootElement(name = "xml")
@Getter
public class WXReceiveRequestVideoMessage extends WXReceiveRequestMessage {
    //视频消息媒体id，可以调用多媒体文件下载接口拉取数据
    @XmlJavaTypeAdapter(WXCDataAdapter.class)
    private String MediaId;
    //视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
    @XmlJavaTypeAdapter(WXCDataAdapter.class)
    private String ThumbMediaId;
}
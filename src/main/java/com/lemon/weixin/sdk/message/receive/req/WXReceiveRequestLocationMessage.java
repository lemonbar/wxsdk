package com.lemon.weixin.sdk.message.receive.req;

import com.lemon.weixin.sdk.util.WXCDataAdapter;
import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by lemon_bar on 2014/12/9.
 */
@XmlRootElement(name = "xml")
@Getter
public class WXReceiveRequestLocationMessage extends WXReceiveRequestMessage {
    //地理位置维度
    @XmlElement
    private String Location_X;
    //地理位置经度
    @XmlElement
    private String Location_Y;
    //地图缩放大小
    @XmlElement
    private String Scale;
    //地理位置信息
    @XmlJavaTypeAdapter(WXCDataAdapter.class)
    private String Label;
}
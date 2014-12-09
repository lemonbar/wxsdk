package com.lemon.weixin.sdk.message.receive.resp;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by lemon_bar on 2014/12/9.
 */
@Getter
public class WXBaseMedia {
    //通过上传多媒体文件，得到的id
    @XmlElement
    private String MediaId;
}
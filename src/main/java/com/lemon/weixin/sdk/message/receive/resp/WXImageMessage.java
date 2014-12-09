package com.lemon.weixin.sdk.message.receive.resp;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by lemon_bar on 2014/12/9.
 */
@Getter
@XmlRootElement(name = "xml")
public class WXImageMessage extends WXBaseMessage {
    @XmlElement(name = "Image")
    private WXBaseMedia Image;
}

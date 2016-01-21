package com.kunbao.weixin.sdk.message.domain.received.event;

import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by lemon_bar on 15/7/6.
 */
@Getter
@ToString(callSuper = true)
@XmlRootElement(name = "xml")
public class WXReceivedLocationEvent extends WXReceivedEvent {
    @XmlElement(name = "Latitude")
    private double latitude;

    @XmlElement(name = "Longitude")
    private double longitude;

    @XmlElement(name = "Precision")
    private double precision;
}

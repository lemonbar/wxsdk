package com.kunbao.weixin.sdk.message.domain.received.event;

import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by lemon_bar on 15/7/3.
 */
@Getter
@ToString(callSuper = true)
@XmlRootElement(name = "xml")
public class WXReceivedUnsubscribeEvent extends WXReceivedEvent {

}

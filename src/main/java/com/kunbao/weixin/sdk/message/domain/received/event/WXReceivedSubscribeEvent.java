package com.kunbao.weixin.sdk.message.domain.received.event;

import com.kunbao.weixin.sdk.util.xml.XMLCDataAdapter;
import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * <xml>
 * <ToUserName><![CDATA[toUser]]></ToUserName>
 * <FromUserName><![CDATA[FromUser]]></FromUserName>
 * <CreateTime>123456789</CreateTime>
 * <MsgType><![CDATA[event]]></MsgType>
 * <Event><![CDATA[subscribe]]></Event>
 * <EventKey><![CDATA[qrscene_123123]]></EventKey>
 * <Ticket><![CDATA[TICKET]]></Ticket>
 * </xml>
 * 下面两个只有通过扫描二维码关注时，才有值。
 * EventKey	事件KEY值，qrscene_为前缀，后面为二维码的参数值
 * Ticket	二维码的ticket，可用来换取二维码图片
 * Created by lemon_bar on 15/7/3.
 */
@Getter
@ToString(callSuper = true)
@XmlRootElement(name = "xml")
public class WXReceivedSubscribeEvent extends WXReceivedEvent {
    //事件KEY值
    @XmlJavaTypeAdapter(XMLCDataAdapter.class)
    @XmlElement(name = "EventKey")
    private String eventKey;

    //二维码的ticket
    @XmlJavaTypeAdapter(XMLCDataAdapter.class)
    @XmlElement(name = "Ticket")
    private String ticket;
}

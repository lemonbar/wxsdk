package com.kunbao.weixin.sdk.message;

import com.kunbao.weixin.sdk.message.domain.base.WXMessageBase;
import com.kunbao.weixin.sdk.message.domain.constant.WXEventType;
import com.kunbao.weixin.sdk.message.domain.constant.WXMessageType;
import com.kunbao.weixin.sdk.message.domain.received.common.*;
import com.kunbao.weixin.sdk.message.domain.received.event.*;
import com.kunbao.weixin.sdk.message.domain.send.xml.WXSendImage;
import com.kunbao.weixin.sdk.message.domain.send.xml.WXSendText;
import com.kunbao.weixin.sdk.util.WXParserUtil;
import com.kunbao.weixin.sdk.util.xml.WXXMLUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by lemon_bar on 15/7/17.
 */
@Slf4j
public class WXMessageService {

    public String produceImage(String fromUser, String toUser, String mediaId) {
        WXSendImage sendImage = new WXSendImage(fromUser, toUser, mediaId);
        return WXXMLUtil.beanToXml(sendImage);
    }

    public String produceText(String fromUser, String toUser, String content) {
        WXSendText sendText = new WXSendText(fromUser, toUser, content);
        return WXXMLUtil.beanToXml(sendText);
    }

    public WXMessageBase consumeMessage(String messageStr) {
        WXMessageType messageType = WXParserUtil.parserPushedMessageType(messageStr);
        if (messageType != null) {
            switch (messageType) {
                case event:
                    return consumeEvent(messageStr);
                case text:
                    return WXParserUtil.parserMessage(messageStr, WXReceivedText.class);
                case image:
                    return WXParserUtil.parserMessage(messageStr, WXReceivedImage.class);
                case voice:
                    return WXParserUtil.parserMessage(messageStr, WXReceivedVoice.class);
                case video:
                    return WXParserUtil.parserMessage(messageStr, WXReceivedVideo.class);
                case shortvideo:
                    return WXParserUtil.parserMessage(messageStr, WXReceivedShortVideo.class);
                case link:
                    return WXParserUtil.parserMessage(messageStr, WXReceivedLink.class);
                case location:
                    return WXParserUtil.parserMessage(messageStr, WXReceivedLocation.class);
                default:
                    log.error("no matched wx message type, the message is {}", messageStr);
                    break;
            }
        } else {
            log.error("weixin message type is null, raw: {}", messageStr);
        }
        return null;
    }

    private WXReceivedEvent consumeEvent(String eventStr) {
        WXEventType eventType = WXParserUtil.parserPushedEventType(eventStr);
        if (eventType != null) {
            switch (eventType) {
                case subscribe:
                    return WXParserUtil.parserMessage(eventStr, WXReceivedSubscribeEvent.class);
                case unsubscribe:
                    return WXParserUtil.parserMessage(eventStr, WXReceivedUnsubscribeEvent.class);
                case SCAN:
                    return WXParserUtil.parserMessage(eventStr, WXReceivedScanEvent.class);
                case LOCATION:
                    return WXParserUtil.parserMessage(eventStr, WXReceivedLocationEvent.class);
                case CLICK:
                    return WXParserUtil.parserMessage(eventStr, WXReceivedClickEvent.class);
                case VIEW:
                    return WXParserUtil.parserMessage(eventStr, WXReceivedViewEvent.class);
                default:
                    log.error("no matched wx event type, the message is {}", eventStr);
                    break;
            }
        }
        return null;
    }

}

package com.kunbao.weixin.sdk.message;

import com.kunbao.weixin.sdk.base.WXHttpDispatch;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import com.kunbao.weixin.sdk.message.domain.base.WXMessageBase;
import com.kunbao.weixin.sdk.message.domain.constant.WXEventType;
import com.kunbao.weixin.sdk.message.domain.constant.WXMessageType;
import com.kunbao.weixin.sdk.message.domain.received.common.*;
import com.kunbao.weixin.sdk.message.domain.received.event.*;
import com.kunbao.weixin.sdk.message.domain.send.json.*;
import com.kunbao.weixin.sdk.message.domain.send.json.metadata.MusicContent;
import com.kunbao.weixin.sdk.message.domain.send.json.metadata.NewsItemContent;
import com.kunbao.weixin.sdk.message.domain.send.json.metadata.VideoContent;
import com.kunbao.weixin.sdk.message.domain.send.xml.*;
import com.kunbao.weixin.sdk.message.domain.template.Industry;
import com.kunbao.weixin.sdk.message.domain.template.MessageInfo;
import com.kunbao.weixin.sdk.message.domain.template.ShortId;
import com.kunbao.weixin.sdk.message.request.WXCustomMessageSendRequest;
import com.kunbao.weixin.sdk.message.request.WXIndustrySetRequest;
import com.kunbao.weixin.sdk.message.request.WXTemplateIdGetRequest;
import com.kunbao.weixin.sdk.message.request.WXTemplateSendRequest;
import com.kunbao.weixin.sdk.message.response.WXTemplateIdGetResponse;
import com.kunbao.weixin.sdk.message.response.WXTemplateSendResponse;
import com.kunbao.weixin.sdk.token.WXTokenController;
import com.kunbao.weixin.sdk.util.WXParserUtil;
import com.kunbao.weixin.sdk.util.xml.WXXMLUtil;

import java.util.List;

/**
 * Created by lemon_bar on 15/7/17.
 */
public class WXMessageService {

    public boolean setIndustryForTemplateMessage(Industry industry) throws WXException {
        WXIndustrySetRequest request = new WXIndustrySetRequest(WXTokenController.getToken(), industry);
        WXJsonResponse response = (WXJsonResponse) WXHttpDispatch.execute(request);
        return response.isSuccess();
    }

    public String getTemplateIdByShortId(String shortId) throws WXException {
        ShortId shortIdObject = new ShortId(shortId);
        WXTemplateIdGetRequest request = new WXTemplateIdGetRequest(WXTokenController.getToken(), shortIdObject);
        WXTemplateIdGetResponse response = (WXTemplateIdGetResponse) WXHttpDispatch.execute(request);
        return response.getTemplateId();
    }

    public String sendTemplateMessage(MessageInfo messageInfo) throws WXException {
        WXTemplateSendRequest request = new WXTemplateSendRequest(WXTokenController.getToken(), messageInfo);
        WXTemplateSendResponse response = (WXTemplateSendResponse) WXHttpDispatch.execute(request);
        return response.getMsgId();
    }

    public String produceImage(String fromUser, String toUser, String mediaId) throws WXException {
        WXSendImage sendImage = new WXSendImage(fromUser, toUser, mediaId);
        return WXXMLUtil.beanToXml(sendImage);
    }

    public String produceText(String fromUser, String toUser, String content) throws WXException {
        WXSendText sendText = new WXSendText(fromUser, toUser, content);
        return WXXMLUtil.beanToXml(sendText);
    }

    public String produceVoice(String fromUser, String toUser, String mediaId) throws WXException {
        WXSendVoice voice = new WXSendVoice(fromUser, toUser, mediaId);
        return WXXMLUtil.beanToXml(voice);
    }

    public String produceVideo(String fromUser, String toUser, WXSendVideoMedia videoMedia) throws WXException {
        WXSendVideo video = new WXSendVideo(fromUser, toUser, videoMedia);
        return WXXMLUtil.beanToXml(video);
    }

    public String produceMusic(String fromUser, String toUser, WXSendMusicMedia musicMedia) throws WXException {
        WXSendMusic music = new WXSendMusic(fromUser, toUser, musicMedia);
        return WXXMLUtil.beanToXml(music);
    }

    public String produceNews(String fromUser, String toUser, List<WXSendNewsItem> newsItems) throws WXException {
        WXSendNews news = new WXSendNews(fromUser, toUser, newsItems);
        return WXXMLUtil.beanToXml(news);
    }

    public boolean sendCustomText(String toUser, String content) throws WXException {
        WXCustomText text = new WXCustomText(toUser, content);
        WXCustomMessageSendRequest request = new WXCustomMessageSendRequest(WXTokenController.getToken(), text);
        WXJsonResponse response = (WXJsonResponse) WXHttpDispatch.execute(request);
        return response.isSuccess();
    }

    public boolean sendCustomImage(String toUser, String mediaId) throws WXException {
        WXCustomImage image = new WXCustomImage(toUser, mediaId);
        WXCustomMessageSendRequest request = new WXCustomMessageSendRequest(WXTokenController.getToken(), image);
        WXJsonResponse response = (WXJsonResponse) WXHttpDispatch.execute(request);
        return response.isSuccess();
    }

    public boolean sendCustomVoice(String toUser, String mediaId) throws WXException {
        WXCustomVoice voice = new WXCustomVoice(toUser, mediaId);
        WXCustomMessageSendRequest request = new WXCustomMessageSendRequest(WXTokenController.getToken(), voice);
        WXJsonResponse response = (WXJsonResponse) WXHttpDispatch.execute(request);
        return response.isSuccess();
    }

    public boolean sendCustomVideo(String toUser, VideoContent videoContent) throws WXException {
        WXCustomVideo video = new WXCustomVideo(toUser, videoContent);
        WXCustomMessageSendRequest request = new WXCustomMessageSendRequest(WXTokenController.getToken(), video);
        WXJsonResponse response = (WXJsonResponse) WXHttpDispatch.execute(request);
        return response.isSuccess();
    }

    public boolean sendCustomMusic(String toUser, MusicContent musicContent) throws WXException {
        WXCustomMusic music = new WXCustomMusic(toUser, musicContent);
        WXCustomMessageSendRequest request = new WXCustomMessageSendRequest(WXTokenController.getToken(), music);
        WXJsonResponse response = (WXJsonResponse) WXHttpDispatch.execute(request);
        return response.isSuccess();
    }

    public boolean sendCustomNews(String toUser, List<NewsItemContent> articles) throws WXException {
        WXCustomNews news = new WXCustomNews(toUser, articles);
        WXCustomMessageSendRequest request = new WXCustomMessageSendRequest(WXTokenController.getToken(), news);
        WXJsonResponse response = (WXJsonResponse) WXHttpDispatch.execute(request);
        return response.isSuccess();
    }

    public WXMessageBase consumeMessage(String messageStr) throws WXException {
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
                    throw new WXException(String.format("no matched wx message type: %s", messageStr));
            }
        }
        throw new WXException(String.format("weixin message type is null, raw content: %s", messageStr));
    }

    private WXReceivedEvent consumeEvent(String eventStr) throws WXException {
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
                case TEMPLATESENDJOBFINISH:
                    return WXParserUtil.parserMessage(eventStr, WXReceivedTemplateSendFinishEvent.class);
                default:
                    throw new WXException(String.format("no matched wx event type: %s", eventStr));
            }
        }
        throw new WXException(String.format("weixin event type is null, raw content: %s", eventStr));
    }

}

package com.lemon.weixin.sdk.message;

import com.lemon.weixin.sdk.base.constants.WXApiUrl;
import com.lemon.weixin.sdk.message.model.receive.WXReceiveTextMessage;
import com.lemon.weixin.sdk.message.model.send.WXSendImageMessage;
import com.lemon.weixin.sdk.message.model.send.WXSendNewsMessage;
import com.lemon.weixin.sdk.message.model.send.WXSendTemplateMessage;
import com.lemon.weixin.sdk.message.model.send.WXSendTextMessage;
import com.lemon.weixin.sdk.message.model.send.content.WXSendNews;
import com.lemon.weixin.sdk.util.WXHttpUtil;
import com.lemon.weixin.sdk.util.WXJsonUtil;
import com.lemon.weixin.sdk.util.WXXmlUtil;

/**
 * Created by 305032265 on 14-12-2.
 */
public class WXMessageService {

    public String sendText(String accessToken, String toUser, String content) {
        WXSendTextMessage textMessage = new WXSendTextMessage(toUser, content);
        String jsonBody = WXJsonUtil.beanToJson(textMessage);
        return sendCustomMessage(accessToken, jsonBody);
    }

    public String sendNews(String accessToken, String toUser, WXSendNews news) {
        WXSendNewsMessage newsMessage = new WXSendNewsMessage(toUser, news);
        String jsonBody = WXJsonUtil.beanToJson(newsMessage);
        return sendCustomMessage(accessToken, jsonBody);
    }

    public String sendImage(String accessToken, String toUser, String mediaId) {
        WXSendImageMessage imageMessage = new WXSendImageMessage(toUser, mediaId);
        String jsonBody = WXJsonUtil.beanToJson(imageMessage);
        return sendCustomMessage(accessToken, jsonBody);
    }

    public String sendCustomMessage(String accessToken, String jsonBody) {
        String url = WXApiUrl.getMessageSendUrl(accessToken);
        return WXHttpUtil.doPost(url, jsonBody);
    }

    public String sendTemplateMessage(String accessToken, WXSendTemplateMessage templateMessage) {
        String jsonBody = WXJsonUtil.beanToJson(templateMessage);
        String url = WXApiUrl.getMessageTemplateSendUrl(accessToken);
        return WXHttpUtil.doPost(url, jsonBody);
    }

    public void receiveText(String xmlStr) {
        WXReceiveTextMessage message =
                WXXmlUtil.xmlToBean(xmlStr, WXReceiveTextMessage.class);

    }
}

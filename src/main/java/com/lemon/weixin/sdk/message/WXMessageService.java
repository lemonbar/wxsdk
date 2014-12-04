package com.lemon.weixin.sdk.message;

import com.google.gson.GsonBuilder;
import com.lemon.weixin.sdk.base.WXHttpService;
import com.lemon.weixin.sdk.constants.WXApiUrl;
import com.lemon.weixin.sdk.message.model.receive.WXReceiveTextMessage;
import com.lemon.weixin.sdk.message.model.send.WXSendTextMessage;
import com.lemon.weixin.sdk.util.WXAccessTokenUtil;
import com.lemon.weixin.sdk.util.WXXmlUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * Created by 305032265 on 14-12-2.
 */
public class WXMessageService {
    public static String sendText(String touser, String content) {
        WXSendTextMessage textMessage = new WXSendTextMessage(touser, content);
        String jsonBody =
                new GsonBuilder().disableHtmlEscaping().create().toJson(textMessage, WXSendTextMessage.class);

        String url = WXApiUrl.getMessageSendUrl(WXAccessTokenUtil.getToken());
        return WXHttpService.postResponseWithURL(url, jsonBody);
    }

    public static void receiveText(String xmlStr) {
        WXReceiveTextMessage message =
                WXXmlUtil.xmlToBean(xmlStr, WXReceiveTextMessage.class);

    }

    //only for test.
    public static void main(String... args) {
        String xml = "<xml><ToUserName>xxxxx</ToUserName><FromUserName>yyyyy</FromUserName><CreateTime>1348831860</CreateTime><MsgType>text</MsgType><Content>hello</Content><MsgId>1234567890123456</MsgId></xml>";
        Reader reader = new StringReader(xml);
        Unmarshaller unmarshaller = null;
        try {
            unmarshaller = JAXBContext.newInstance(WXReceiveTextMessage.class).createUnmarshaller();
            WXReceiveTextMessage result = (WXReceiveTextMessage) unmarshaller.unmarshal(reader);
            System.out.println(result);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}

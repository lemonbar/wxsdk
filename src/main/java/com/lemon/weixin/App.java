package com.lemon.weixin;

import com.lemon.weixin.sdk.base.WXBaseService;
import com.lemon.weixin.sdk.base.WXTokenService;
import com.lemon.weixin.sdk.base.constants.WXApiUrl;
import com.lemon.weixin.sdk.base.req.WXShortUrlAction;
import com.lemon.weixin.sdk.media.WXMediaService;
import com.lemon.weixin.sdk.media.resp.WXMedia;
import com.lemon.weixin.sdk.message.WXMessageService;
import com.lemon.weixin.sdk.message.receive.WXReceiveTextMessage;
import com.lemon.weixin.sdk.message.receive.resp.WXImageMessage;
import com.lemon.weixin.sdk.message.receive.resp.WXNewsMessage;
import com.lemon.weixin.sdk.message.send.WXSendTemplateMessage;
import com.lemon.weixin.sdk.message.send.content.WXSendArticle;
import com.lemon.weixin.sdk.message.send.content.WXSendNews;
import com.lemon.weixin.sdk.message.send.content.WXSendTemplateItem;
import com.lemon.weixin.sdk.qrcode.WXQrcodeService;
import com.lemon.weixin.sdk.qrcode.req.WXActionInfo;
import com.lemon.weixin.sdk.qrcode.resp.WXQrcodeTicket;
import com.lemon.weixin.sdk.qrcode.req.WXTempQrcode;
import com.lemon.weixin.sdk.user.WXUserService;
import com.lemon.weixin.sdk.user.resp.WXUserInfo;
import com.lemon.weixin.sdk.user.resp.WXUserPage;
import com.lemon.weixin.sdk.util.WXXmlUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
    private static String openId = "olONIt17KaZJPbcoeMb8oZ5O7j8E";
    private static String mediaId = null;
    private static String template_id = "I29KF5q1-_y2akKp1v2Fo1xCkpqYuF8P_2PQ_xK6NHE";
    private static String image = "qrcode_for_gh_eapp_860.jpg";

    private static String longUrl = null;

    public static void main(String[] args) {
        testXmlConverter();
//        testCreateQrcode();
//        testLong2ShortUrl();
//        testSendMessageTemplate();
//        testGetUserInfoApi("DYun");
//        testSendNewsMessage();
//        if (openId != null) {
//            testUploadImage();
//            if (mediaId != null) {
//                testSendImage();
//            }
//        }
        System.out.println("Hello World!");
    }

    public static void testXmlConverter() {
        String testStr = "<xml>\n" +
                "<ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                "<FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
                "<CreateTime>12345678</CreateTime>\n" +
                "<MsgType><![CDATA[news]]></MsgType>\n" +
                "<ArticleCount>2</ArticleCount>\n" +
                "<Articles>\n" +
                "<item>\n" +
                "<Title><![CDATA[title1]]></Title> \n" +
                "<Description><![CDATA[description1]]></Description>\n" +
                "<PicUrl><![CDATA[picurl]]></PicUrl>\n" +
                "<Url><![CDATA[url]]></Url>\n" +
                "</item>\n" +
                "<item>\n" +
                "<Title><![CDATA[title]]></Title>\n" +
                "<Description><![CDATA[description]]></Description>\n" +
                "<PicUrl><![CDATA[picurl]]></PicUrl>\n" +
                "<Url><![CDATA[url]]></Url>\n" +
                "</item>\n" +
                "</Articles>\n" +
                "</xml>";

        System.out.println(testStr);
        System.out.println("##################################################");
        WXNewsMessage message = WXXmlUtil.xmlToBean(testStr, WXNewsMessage.class);

        String xml = WXXmlUtil.beanToXml(message, "UTF-8");

        WXNewsMessage message2 = WXXmlUtil.xmlToBean(xml, WXNewsMessage.class);

        System.out.println(xml);
    }

    public static void testLong2ShortUrl() {
        WXTokenService tokenService = new WXTokenService();
        WXBaseService baseService = new WXBaseService();

        String result = baseService.longToShortUrl(tokenService.getAccessToken(), new WXShortUrlAction(longUrl));
        System.out.println(result);
    }

    public static void testCreateQrcode() {
        WXTokenService tokenService = new WXTokenService();
        WXQrcodeService qrcodeService = new WXQrcodeService();

        WXTempQrcode tempQrcode = new WXTempQrcode(1800, new WXActionInfo(123));
        WXQrcodeTicket ticket = qrcodeService.createTempQrcode(tokenService.getAccessToken(), tempQrcode);

        System.out.println("ticket is-------- " + ticket.getTicket());

        longUrl = WXApiUrl.getQrcodeShowUrl(ticket.getTicket());

        System.out.println("url is----------- " + ticket.getUrl());
    }

    public static void testUploadImage() {
        WXTokenService tokenService = new WXTokenService();
        WXMediaService mediaService = new WXMediaService();
        String imagePath = App.class.getClassLoader().getResource(image).getPath();
        //decode url for utf-8 chars in image path.
        try {
            imagePath = URLDecoder.decode(imagePath, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        WXMedia result = mediaService.uploadImage(tokenService.getAccessToken(), imagePath);
        if (result != null) {
            mediaId = result.getMedia_id();
            System.out.println(mediaId);
        }
    }

    public static void testSendImage() {
        WXTokenService tokenService = new WXTokenService();
        WXMessageService messageService = new WXMessageService();

        String result = messageService.sendImage(tokenService.getAccessToken(), openId, mediaId);
        System.out.println(result);
    }

    public static void testSendMessageTemplate() {
        WXTokenService tokenService = new WXTokenService();
        WXMessageService messageService = new WXMessageService();

        Map<String, WXSendTemplateItem> data = new HashMap<String, WXSendTemplateItem>();
        data.put("userName", new WXSendTemplateItem("各位同事，欢迎购买。。。", "#0A0A0A"));
        data.put("courseName", new WXSendTemplateItem("CT 1000", "#CCCCCC"));
        data.put("date", new WXSendTemplateItem("2014年9月16日", "#CCCCCC"));

        WXSendTemplateMessage message = new WXSendTemplateMessage(openId, template_id, "http://weixin.qq.com/download", "#FF0000", data);

        String result = messageService.sendTemplateMessage(tokenService.getAccessToken(), message);
        System.out.println(result);
    }

    public static void testSendNewsMessage() {
        WXTokenService tokenService = new WXTokenService();
        WXMessageService messageService = new WXMessageService();

        //todo: initial news article.
        WXSendNews news = new WXSendNews();
        WXSendArticle article1 = new WXSendArticle();
        article1.setDescription("各位同事，我们医院购买了GE的CT 1000设备，厂家为我们提供了丰富的应用培训课程，请大家访问一下链接进行申请：https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx0cd7b36db6ebbc17&redirect_uri=http://edu.gehealthcare.cn/wx/user/signup/1&response_type=code&scope=snsapi_base&state=123#wechat_redirect");
        article1.setTitle("This is title");
        article1.setPicurl("https://github.com/lemonbar/wxsdk/blob/master/src/test/test.jpg");
        article1.setUrl("https://mp.weixin.qq.com/misc/getqrcode?fakeid=3075007380&token=148552068&style=1&action=show");
        news.getArticles().add(article1);

        String result = messageService.sendNews(tokenService.getAccessToken(), openId, news);
        System.out.println(result);
    }

    //get nick name open id.
    public static void testGetUserInfoApi(String nickname) {
        WXTokenService tokenService = new WXTokenService();
        WXUserService userService = new WXUserService();

        String token = tokenService.getAccessToken();
        WXUserPage wxUserPage = userService.getUserList(token, "");

        if (wxUserPage != null && wxUserPage.getData().getOpenid() != null) {
            List<String> openIdList = wxUserPage.getData().getOpenid();
            for (String tmp : openIdList) {
                WXUserInfo userInfo = userService.getUserInfo(token, tmp);
                if (userInfo != null) {
                    System.out.println(userInfo.getNickname());
                    if (userInfo.getNickname().equals(nickname)) {
                        openId = userInfo.getOpenid();
                        break;
                    }
                }
            }
        }
    }
}

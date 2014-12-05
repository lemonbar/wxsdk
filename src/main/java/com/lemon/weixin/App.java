package com.lemon.weixin;

import com.lemon.weixin.sdk.base.WXTokenService;
import com.lemon.weixin.sdk.media.WXMediaService;
import com.lemon.weixin.sdk.media.model.WXMedia;
import com.lemon.weixin.sdk.message.WXMessageService;
import com.lemon.weixin.sdk.message.model.send.WXSendNewsMessage;
import com.lemon.weixin.sdk.message.model.send.content.WXSendArticle;
import com.lemon.weixin.sdk.message.model.send.content.WXSendNews;
import com.lemon.weixin.sdk.user.WXUserService;
import com.lemon.weixin.sdk.user.model.WXUserInfo;
import com.lemon.weixin.sdk.user.model.WXUserPage;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    private static String openId = "olONIt17KaZJPbcoeMb8oZ5O7j8E";
    private static String mediaId = null;
    private static String image = "qrcode_for_gh_eapp.jpg";

    public static void main(String[] args) {
//        testSendMessageTemplate();
//        testGetUserInfoApi("DYun");
//        testSendNewsMessage();
        testUploadImage();
        if (mediaId != null) {
            testSendImage();
        }
        System.out.println("Hello World!");
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

        String content = "{\"touser\":\"olONIt-ysZO4zk5IJggNMaCq7qCU\",\n" +
                "           \"template_id\":\"I29KF5q1-_y2akKp1v2Fo1xCkpqYuF8P_2PQ_xK6NHE\",\n" +
                "           \"url\":\"http://weixin.qq.com/download\",\n" +
                "           \"topcolor\":\"#FF0000\",\n" +
                "           \"data\":{\n" +
                "                   \"userName\": {\n" +
                "                       \"value\":\"各位同事，我们医院购买了GE的CT 1000设备，厂家为我们提供了丰富的应用培训课程，请大家访问一下链接进行申请\",\n" +
                "                       \"color\":\"#0A0A0A\"\n" +
                "                   },\n" +
                "                   \"courseName\":{\n" +
                "                       \"value\":\"CT 1000\",\n" +
                "                       \"color\":\"#CCCCCC\"\n" +
                "                   },\n" +
                "                   \"date\":{\n" +
                "                       \"value\":\"2014年9月16日\",\n" +
                "                       \"color\":\"#CCCCCC\"\n" +
                "                   },\n" +
                "                   \"remark\":{\n" +
                "                       \"value\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx0cd7b36db6ebbc17&redirect_uri=http://edu.gehealthcare.cn/wx/user/signup/1&response_type=code&scope=snsapi_base&state=123#wechat_redirect\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   }\n" +
                "           }\n" +
                "       }";

        String result = messageService.sendTemplate(tokenService.getAccessToken(), content);
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
            for (String openId : openIdList) {
                WXUserInfo userInfo = userService.getUserInfo(token, openId);
                if (userInfo != null) {
                    System.out.println(userInfo.getNickname());
                    if (userInfo.getNickname().equals(nickname)) {
                        System.out.println(userInfo.getOpenid());
                    }
                }
            }
        }
    }
}

package com.kunbao.weixin.sdk.message;

import com.google.common.collect.Lists;
import com.kunbao.weixin.sdk.management.oauth2.WXOAuthService;
import com.kunbao.weixin.sdk.management.user.WXUserService;
import com.kunbao.weixin.sdk.management.user.domain.WXLang;
import com.kunbao.weixin.sdk.management.user.domain.WXOpenIdList;
import com.kunbao.weixin.sdk.management.user.response.WXUserGetResponse;
import com.kunbao.weixin.sdk.management.user.response.WXUserInfoResponse;
import com.kunbao.weixin.sdk.message.domain.send.json.metadata.NewsItemContent;
import com.kunbao.weixin.sdk.message.domain.send.xml.WXSendMusicMedia;
import com.kunbao.weixin.sdk.message.domain.send.xml.WXSendNewsItem;
import com.kunbao.weixin.sdk.message.domain.send.xml.WXSendVideoMedia;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.List;

/**
 * Created by lemon_bar on 15/7/23.
 */
public class WXMessageServiceTest extends TestCase {
    private WXMessageService messageService;
    private WXUserService userService;
    private WXOAuthService wxoAuthService;

    private final String testOpenId = "oGyUyuHlp9qFWaq6kSVvag1ms25g";//"oGyUyuN286qRai_jqs1Hg8C6Xrxg";// "oGyUyuHlp9qFWaq6kSVvag1ms25g oGyUyuN286qRai_jqs1Hg8C6Xrxg";
    private final String REPLY_NOTIFICATION_TEMPLATE_ID = "u4F24I6P_nhdMw5HDTZeBoBsdqqiKN9b1XB7pMq3R1w";
    private final String questionTemplate = "X8vBkDynfNb4Ks1G3AVoYvenWe9mrXCV5M_JTKE-yDQ";//"rOf1_MLpn5ofPGOawNgHCMPLMc-svB0QPhD23BOVFYE";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.messageService = new WXMessageService();
        this.userService = new WXUserService();
        this.wxoAuthService = new WXOAuthService();
    }

    public void testProduceVideo() throws Exception {
        WXSendVideoMedia videoMedia = new WXSendVideoMedia("media", "title", "description");
        String xml = this.messageService.produceVideo("fromUser", "toUser", videoMedia);
        Assert.assertNotNull(xml);
    }

    public void testProduceNews() throws Exception {
        List<WXSendNewsItem> newsItems = Lists.newArrayList();
        WXSendNewsItem item1 = new WXSendNewsItem("title1", "description1", "picUrl1", "url1");
        newsItems.add(item1);
        String xml = this.messageService.produceNews("fromUser", "toUser", newsItems);
        Assert.assertNotNull(xml);
    }

    public void testProduceVoice() throws Exception {
        String xml = this.messageService.produceVoice("fromUser", "toUser", "mediaId");
        Assert.assertNotNull(xml);
    }

    public void testProduceMusic() throws Exception {
        WXSendMusicMedia musicMedia = new WXSendMusicMedia("thumbMediaId", "title", "description", "musicUrl", "hpmusicUrl");
        String xml = this.messageService.produceMusic("fromUser", "toUser", musicMedia);
        Assert.assertNotNull(xml);
    }

    public void testConsumeMessage() throws Exception {
        boolean result = this.messageService.sendCustomText("toUser", "内容");
        Assert.assertTrue("send message successfully", result);
    }

    public void testSendCustomNews() throws Exception {
        List<NewsItemContent> newsItemContents = Lists.newArrayList();
        NewsItemContent news1 = new NewsItemContent("title1", "desc1", "url1", "picurl1");
        NewsItemContent news2 = new NewsItemContent("title2", "desc2", "url2", "picurl2");
        newsItemContents.add(news1);
        newsItemContents.add(news2);
        boolean result = this.messageService.sendCustomNews("toUser", newsItemContents);
        Assert.assertTrue("send news successfully", result);
    }

    public void testSendTemplateMessage() throws Exception {
        WXUserGetResponse response = this.userService.getUserList("");
        WXOpenIdList lists = response.getOpenIdList();
        for (String item : lists.getOpenIdList()) {
//            String questionUrl = wxoAuthService.wxAuthUrl("http://wx.doctorin.cn/qa/question/60", "snsapi_base", "questionTemplateMessage");
//            MessageInfo messageInfo = new MessageInfo(testOpenId, questionTemplate, questionUrl, StringUtils.EMPTY);
//            String title = String.format("%s(%s)提出了一个新问题", "刘子沛", "306医院");
//            messageInfo.addItem("first", new ItemValue(title, "#0f7f12"));
//
//            messageInfo.addItem("keyword1", new ItemValue("三岁女孩出生脸一侧有鲜红斑痣约掌心大小。", "#0f7f12"));
//            messageInfo.addItem("keyword2", new ItemValue("[暂无，点击率先回答]", "#c1c1c1"));
//
//            messageInfo.addItem("keyword3", new ItemValue("2015年12月17日", "#c1c1c1"));
//            messageInfo.addItem("remark", new ItemValue("点击查看问题详情", "#c1c1c1"));
//            WXUserInfoResponse info = this.userService.getUserInfo(item, WXLang.zh_CN);
//            MessageInfo messageInfo = new MessageInfo(info.getOpenId(), REPLY_NOTIFICATION_TEMPLATE_ID, wxoAuthService.wxAuthUrl("http://wx.doctorin.cn/qa/question/list", "snsapi_base", "questionList"), "#173177");
//            messageInfo.addItem("first", new ItemValue("熊大夫新版上线了！快来体验。\n", "#0f7f12"));
//            messageInfo.addItem("keyword1", new ItemValue("\n1. 执业信息熊掌柜已经帮你认证。在人脉里会有意外发现哦。\n"
//                    + "2. 没有认证的，你的资料不全啊。熊掌柜不认识你啊，快填全信息，找人帮你认证吧。\n"
//                    + "3. 火速把教育背景填上吧，这样就能发现你的校友了。\n", "#0f7f12"));
//            messageInfo.addItem("keyword2", new ItemValue("2015年12月14日", "#c1c1c1"));
//        messageInfo.addItem("keyword3", new ItemValue("这是回复内容", "#00bdd3"));
//        messageInfo.addItem("remark", new ItemValue("相关问题：这是消息内容", "#000"));
//            String result = this.messageService.sendTemplateMessage(messageInfo);
//            System.out.println(result);
//            System.out.println("openid is " + info.getOpenId() + "; name is " + info.getNickname());
        }
    }

    public void testSendCustomText() throws Exception {

//        List<WXUserGroup> userGroups = this.userService.getUserGroup();
//        for (WXUserGroup group : userGroups) {
//            System.out.println(group.getId() + group.getName());
//        }

        WXUserGetResponse response = this.userService.getUserList(null);
        for (String openId : response.getOpenIdList().getOpenIdList()) {
            WXUserInfoResponse userInfo = this.userService.getUserInfo(openId, WXLang.zh_CN);
            System.out.println(userInfo.getGroupId() + ", " + userInfo.getNickname() + ", " + userInfo.getOpenId());
//            if (userInfo.getOpenId().equals("oGyUyuOsnzuX-F_oWZAkT89ZKIJg")) {
//            try {
//                MessageInfo messageInfo = new MessageInfo(openId, REPLY_NOTIFICATION_TEMPLATE_ID, wxoAuthService.wxAuthUrl("http://doctorin.cn/question/list", "snsapi_base", "questionList"), "#173177");
//                messageInfo.addItem("first", new ItemValue("亲爱的医生们,在大家的建议指导下，我们又有新的更新哦\n", "#0f7f12"));
//                messageInfo.addItem("keyword1", new ItemValue("\n1. 问答部分整体页面的调整，看着更顺眼\n"
//                        + "2. 支持回复图片，内容更充实\n"
//                        + "3. 支持修改问题补充内容和添加图片\n"
//                        + "4. 去除部分手机左上角的奇怪数字\n"
//                        + "5. 问题列表返回后，停留在原位置，就不用麻烦再从头寻找了\n"
//                        + "\n尝试一下发布问题，看看同行回复吧!\n", "#0f7f12"));
//                messageInfo.addItem("keyword2", new ItemValue("2015年11月11日", "#c1c1c1"));
////        messageInfo.addItem("keyword3", new ItemValue("这是回复内容", "#00bdd3"));
////        messageInfo.addItem("remark", new ItemValue("相关问题：这是消息内容", "#000"));
//                String result = this.messageService.sendTemplateMessage(messageInfo);
//                System.out.println(result);
////            }
////        this.messageService.sendCustomText("oGyUyuN286qRai_jqs1Hg8C6Xrxg", "亲爱的医生们,"
////                + "在大家的建议指导下，我们又有新的更新哦/可爱\n"
////                + "1. 问答部分整体页面的调整，看着更顺眼\n"
////                + "2. 支持回复图片，内容更充实\n"
////                + "3. 支持修改问题补充内容和添加图片\n"
////                + "4. 去除部分手机左上角的奇怪数字\n"
////                + "5. 问题列表返回后，停留在原位置，就不用麻烦再从头寻找了\n"
////                + "\n尝试一下发布问题，看看同行回复吧!/礼物\n"
////                + "/爱心/爱心/爱心\n");
////                    System.out.println(userInfo.getNickname() + " send successfully.");
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
//        }


//        String content = this.messageService.produceText("gh_d050849f8f86", testOpenId, "test");
//        boolean result = this.messageService.sendCustomText(testOpenId, "终于被你发现了！我们这么低调都逃不过你的慧眼！/偷笑\n" +
//                "资讯·品牌·人脉，每日精选更新。/奋斗\n" +
//                "有品，有料，有用，是我们的特色。/::,@\n" +
//                "坐下来，跟我们一起读懂行业吧！/勾引\n" +
//                "品观MM欢迎任何吐槽、点赞、勾搭，随时给我们留言吧~/太阳");
//        System.out.println(result);
//        System.out.println(content);


        }
    }
}
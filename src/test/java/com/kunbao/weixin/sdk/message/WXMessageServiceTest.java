package com.kunbao.weixin.sdk.message;

import com.google.common.collect.Lists;
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

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.messageService = new WXMessageService();
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
}
package com.kunbao.weixin.sdk.management.material;

import com.kunbao.weixin.sdk.management.material.domain.MaterialPageableRequest;
import com.kunbao.weixin.sdk.management.material.domain.NewsItem;
import com.kunbao.weixin.sdk.management.material.domain.NewsList;
import com.kunbao.weixin.sdk.management.material.domain.constant.MaterialType;
import com.kunbao.weixin.sdk.management.material.domain.constant.MediaType;
import com.kunbao.weixin.sdk.management.material.response.*;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lemon_bar on 15/7/12.
 */
public class WXMaterialServiceTest extends TestCase {
    private WXMaterialService wxMaterialService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        wxMaterialService = new WXMaterialService();
    }

    public void testGetCount() throws Exception {
        WXGetMaterialCountResponse response = wxMaterialService.getCount();
        System.out.println(response.getImageCount());
    }

    public void testGetCommonMaterialList() throws Exception {
        MaterialPageableRequest pageableRequest = new MaterialPageableRequest(MaterialType.image, 0, 4);
        WXGetCommonMaterialListResponse response = wxMaterialService.getCommonMaterialList(pageableRequest);
        System.out.println(response.getItems().get(0).getMediaId());
        System.out.println(response.getItems().get(0).getUrl());
        System.out.println(response.getItems().get(0).getName());
    }

    public void testGetNewsMaterialList() throws Exception {
        MaterialPageableRequest pageableRequest = new MaterialPageableRequest(MaterialType.news, 0, 4);
        WXGetNewsMaterialListResponse response = wxMaterialService.getNewsMaterialList(pageableRequest);
        System.out.println(response);
    }

    public void testUploadMedia() throws Exception {
        String response = wxMaterialService.uploadTempMedia(MediaType.image, "E:\\MyPrivateDocument\\Pic\\DSC_0112.JPG");
        System.out.println(response);
    }

    public void testAddNewsList() throws Exception {
        NewsList newsList = new NewsList();
        List<NewsItem> newsItems = new ArrayList<NewsItem>();
        NewsItem newsItem = new NewsItem();
        newsItem.setTitle("测试标题三");
        newsItem.setAuthor("作者三");
        newsItem.setContent("内容三");
        newsItem.setDigest("摘要三");
        newsItem.setContentSourceUrl("www.baidu.com");
        newsItem.setShowCoverPic(true);
        newsItem.setThumbMediaId("lUmvJ8CJKup_r9IA46u_ofwvg-YfdUnPtw9H0tHTlck");
        newsItems.add(newsItem);
        newsList.setNewsItems(newsItems);

        String response = wxMaterialService.addNewsList(newsList);
        System.out.println("test");
    }

    public void testDeleteMaterial() throws Exception {

    }

    public void testAddCommonMaterial() throws Exception {
        WXAddCommonMaterialResponse response = wxMaterialService.addCommonMaterial("/Users/limeng/Documents/7111838.jpeg");
        System.out.println(response.getMediaId());
        System.out.println(response.getUrl());
    }
}
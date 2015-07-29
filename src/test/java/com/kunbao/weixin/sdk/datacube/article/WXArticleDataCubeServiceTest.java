package com.kunbao.weixin.sdk.datacube.article;

import com.kunbao.weixin.sdk.base.domain.constant.WXAppConstant;
import com.kunbao.weixin.sdk.datacube.article.domain.ArticleData;
import junit.framework.TestCase;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by lemon_bar on 15/7/29.
 */
public class WXArticleDataCubeServiceTest extends TestCase {

    private WXArticleDataCubeService wxArticleDataCubeService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        WXAppConstant.init("wx4f135cf07185a290", "4b8bffa34e67d63f8a7f080752a36c40", "DNXX2XDF", "UyiZ5eWawdxA6cNbMTwyMKSu9nUDOutrbkDLhbxGULS");
        this.wxArticleDataCubeService = new WXArticleDataCubeService();
    }

    public void testGetArticleSummary() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -5);
        Date start = calendar.getTime();
        List<ArticleData> articleData = this.wxArticleDataCubeService.getArticleSummary(start, start);
        System.out.println(articleData);
    }
}
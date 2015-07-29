package com.kunbao.weixin.sdk.datacube.article;

import com.kunbao.weixin.sdk.base.WXHttpDispatch;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.datacube.article.domain.*;
import com.kunbao.weixin.sdk.datacube.article.request.*;
import com.kunbao.weixin.sdk.datacube.article.response.*;
import com.kunbao.weixin.sdk.token.WXTokenController;

import java.util.Date;
import java.util.List;

/**
 * Created by lemon_bar on 15/7/29.
 */
public class WXArticleDataCubeService {
    public List<ArticleData> getArticleSummary(Date start, Date end) throws WXException {
        WXArticleSummaryGetRequest request = new WXArticleSummaryGetRequest(WXTokenController.getToken(), start, end);
        WXArticleSummaryGetResponse response = (WXArticleSummaryGetResponse) WXHttpDispatch.execute(request);
        return response.getArticleDataSummary();
    }

    public List<ArticleTotalData> getArticleTotal(Date start, Date end) throws WXException {
        WXArticleTotalGetRequest request = new WXArticleTotalGetRequest(WXTokenController.getToken(), start, end);
        WXArticleTotalGetResponse response = (WXArticleTotalGetResponse) WXHttpDispatch.execute(request);
        return response.getArticleTotalData();
    }

    public List<UserReadData> getArticleUserRead(Date start, Date end) throws WXException {
        WXArticleUserReadGetRequest request = new WXArticleUserReadGetRequest(WXTokenController.getToken(), start, end);
        WXArticleUserReadGetResponse response = (WXArticleUserReadGetResponse) WXHttpDispatch.execute(request);
        return response.getUserReadData();
    }

    public List<UserReadHourData> getArticleUserReadHour(Date start, Date end) throws WXException {
        WXArticleUserReadHourGetRequest request = new WXArticleUserReadHourGetRequest(WXTokenController.getToken(), start, end);
        WXArticleUserReadHourGetResponse response = (WXArticleUserReadHourGetResponse) WXHttpDispatch.execute(request);
        return response.getUserReadHourData();
    }

    public List<ArticleShareData> getArticleShare(Date start, Date end) throws WXException {
        WXArticleUserShareGetRequest request = new WXArticleUserShareGetRequest(WXTokenController.getToken(), start, end);
        WXArticleUserShareGetResponse response = (WXArticleUserShareGetResponse) WXHttpDispatch.execute(request);
        return response.getArticleShareData();
    }

    public List<ArticleShareHourData> getArticleShareHour(Date start, Date end) throws WXException {
        WXArticleUserShareHourGetRequest request = new WXArticleUserShareHourGetRequest(WXTokenController.getToken(), start, end);
        WXArticleUserShareHourGetResponse response = (WXArticleUserShareHourGetResponse) WXHttpDispatch.execute(request);
        return response.getArticleShareHourData();
    }
}

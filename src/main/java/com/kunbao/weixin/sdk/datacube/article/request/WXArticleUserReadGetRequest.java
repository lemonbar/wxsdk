package com.kunbao.weixin.sdk.datacube.article.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.datacube.article.response.WXArticleUserReadGetResponse;
import com.kunbao.weixin.sdk.datacube.base.domain.DatePeriod;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

import java.util.Date;

/**
 * https://api.weixin.qq.com/datacube/getuserread?access_token=ACCESS_TOKEN
 * 最大时间跨度 3天
 * Created by lemon_bar on 15/7/29.
 */
public class WXArticleUserReadGetRequest extends WXRequest<WXArticleUserReadGetResponse> {
    public WXArticleUserReadGetRequest(String token, Date start, Date end) throws WXException {
        super();
        this.method = WXHTTPMethod.POST;
        this.path = "/datacube/getuserread";
        this.parameters.put("access_token", token);
        DatePeriod datePeriod = new DatePeriod(start, end);
        this.body = WXJsonUtil.beanToJson(datePeriod);
    }
    
    @Override
    public WXArticleUserReadGetResponse createResponse(String body) throws WXException {
        return WXJsonUtil.jsonToBean(body, WXArticleUserReadGetResponse.class);
    }
}

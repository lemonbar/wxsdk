package com.kunbao.weixin.sdk.datacube.article.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.datacube.article.response.WXArticleUserShareGetResponse;
import com.kunbao.weixin.sdk.datacube.base.domain.DatePeriod;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

import java.util.Date;

/**
 * https://api.weixin.qq.com/datacube/getusershare?access_token=ACCESS_TOKEN
 * 最大时间跨度 7天
 * Created by lemon_bar on 15/7/29.
 */
public class WXArticleUserShareGetRequest extends WXRequest<WXArticleUserShareGetResponse> {
    public WXArticleUserShareGetRequest(String token, Date start, Date end) throws WXException {
        super();
        this.method = WXHTTPMethod.POST;
        this.path = "/datacube/getusershare";
        this.parameters.put("access_token", token);
        DatePeriod datePeriod = new DatePeriod(start, end);
        this.body = WXJsonUtil.beanToJson(datePeriod);
    }

    @Override
    public WXArticleUserShareGetResponse createResponse(String body) throws WXException {
        return WXJsonUtil.jsonToBean(body, WXArticleUserShareGetResponse.class);
    }
}

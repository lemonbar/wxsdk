package com.kunbao.weixin.sdk.datacube.article.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.datacube.article.response.WXArticleUserShareHourGetResponse;
import com.kunbao.weixin.sdk.datacube.base.domain.DatePeriod;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

import java.util.Date;

/**
 * https://api.weixin.qq.com/datacube/getusersharehour?access_token=ACCESS_TOKEN
 * 最大时间跨度 1天
 * Created by lemon_bar on 15/7/29.
 */
public class WXArticleUserShareHourGetRequest extends WXRequest<WXArticleUserShareHourGetResponse> {
    public WXArticleUserShareHourGetRequest(String token, Date start, Date end) throws WXException {
        super();
        this.method = WXHTTPMethod.POST;
        this.path = "/datacube/getusersharehour";
        this.parameters.put("access_token", token);
        DatePeriod datePeriod = new DatePeriod(start, end);
        this.body = WXJsonUtil.beanToJson(datePeriod);
    }

    @Override
    public WXArticleUserShareHourGetResponse createResponse(String body) throws WXException {
        return WXJsonUtil.jsonToBean(body, WXArticleUserShareHourGetResponse.class);
    }
}

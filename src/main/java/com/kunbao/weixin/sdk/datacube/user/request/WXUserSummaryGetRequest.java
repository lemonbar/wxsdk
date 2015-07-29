package com.kunbao.weixin.sdk.datacube.user.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.datacube.base.domain.DatePeriod;
import com.kunbao.weixin.sdk.datacube.user.response.WXUserSummaryGetResponse;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

import java.util.Date;

/**
 * https://api.weixin.qq.com/datacube/getusersummary?access_token=ACCESS_TOKEN
 * Created by lemon_bar on 15/7/27.
 */
public class WXUserSummaryGetRequest extends WXRequest<WXUserSummaryGetResponse> {
    public WXUserSummaryGetRequest(String token, Date start, Date end) throws WXException {
        super();
        this.method = WXHTTPMethod.POST;
        this.path = "/datacube/getusersummary";
        this.parameters.put("access_token", token);
        DatePeriod datePeriod = new DatePeriod(start, end);
        this.body = WXJsonUtil.beanToJson(datePeriod);
    }

    @Override
    public WXUserSummaryGetResponse createResponse(String body) throws WXException {
        return WXJsonUtil.jsonToBean(body, WXUserSummaryGetResponse.class);
    }
}

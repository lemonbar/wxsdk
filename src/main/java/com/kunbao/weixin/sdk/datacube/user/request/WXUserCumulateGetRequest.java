package com.kunbao.weixin.sdk.datacube.user.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.datacube.base.domain.DatePeriod;
import com.kunbao.weixin.sdk.datacube.user.response.WXUserCumulateGetResponse;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

import java.util.Date;

/**
 * https://api.weixin.qq.com/datacube/getusercumulate?access_token=ACCESS_TOKEN
 * Created by lemon_bar on 15/7/29.
 */
public class WXUserCumulateGetRequest extends WXRequest<WXUserCumulateGetResponse> {
    public WXUserCumulateGetRequest(String token, Date start, Date end) throws WXException {
        super();
        this.method = WXHTTPMethod.POST;
        this.path = "/datacube/getusercumulate";
        this.parameters.put("access_token", token);
        DatePeriod datePeriod = new DatePeriod(start, end);
        this.body = WXJsonUtil.beanToJson(datePeriod);
    }

    @Override
    public WXUserCumulateGetResponse createResponse(String body) throws WXException {
        return WXJsonUtil.jsonToBean(body, WXUserCumulateGetResponse.class);
    }
}

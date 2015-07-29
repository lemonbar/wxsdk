package com.kunbao.weixin.sdk.datacube.wxinterface.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.datacube.base.domain.DatePeriod;
import com.kunbao.weixin.sdk.datacube.wxinterface.response.WXInterfaceSummaryGetResponse;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

import java.util.Date;

/**
 * 获取接口分析数据（getinterfacesummary）
 * 30
 * https://api.weixin.qq.com/datacube/getinterfacesummary?access_token=ACCESS_TOKEN
 * Created by lemon_bar on 15/7/29.
 */
public class WXInterfaceSummaryGetRequest extends WXRequest<WXInterfaceSummaryGetResponse> {
    public WXInterfaceSummaryGetRequest(String token, Date start, Date end) throws WXException {
        super();
        this.method = WXHTTPMethod.POST;
        this.path = "/datacube/getinterfacesummary";
        this.parameters.put("access_token", token);
        DatePeriod datePeriod = new DatePeriod(start, end);
        this.body = WXJsonUtil.beanToJson(datePeriod);
    }

    @Override
    public WXInterfaceSummaryGetResponse createResponse(String body) throws WXException {
        return WXJsonUtil.jsonToBean(body, WXInterfaceSummaryGetResponse.class);
    }
}

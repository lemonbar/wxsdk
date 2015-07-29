package com.kunbao.weixin.sdk.datacube.message.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.datacube.base.domain.DatePeriod;
import com.kunbao.weixin.sdk.datacube.message.response.WXUpstreamMsgDistGetResponse;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

import java.util.Date;

/**
 * 获取消息发送分布月数据（getupstreammsgdistmonth）
 * 30
 * https://api.weixin.qq.com/datacube/getupstreammsgdistmonth?access_token=ACCESS_TOKEN
 * Created by lemon_bar on 15/7/29.
 */
public class WXUpstreamMsgDistMonthGetRequest extends WXRequest<WXUpstreamMsgDistGetResponse> {
    public WXUpstreamMsgDistMonthGetRequest(String token, Date start, Date end) throws WXException {
        super();
        this.method = WXHTTPMethod.POST;
        this.path = "/datacube/getupstreammsgdistmonth";
        this.parameters.put("access_token", token);
        DatePeriod datePeriod = new DatePeriod(start, end);
        this.body = WXJsonUtil.beanToJson(datePeriod);
    }

    @Override
    public WXUpstreamMsgDistGetResponse createResponse(String body) throws WXException {
        return WXJsonUtil.jsonToBean(body, WXUpstreamMsgDistGetResponse.class);
    }
}

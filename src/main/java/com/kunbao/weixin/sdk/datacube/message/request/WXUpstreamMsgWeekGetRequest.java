package com.kunbao.weixin.sdk.datacube.message.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.datacube.base.domain.DatePeriod;
import com.kunbao.weixin.sdk.datacube.message.response.WXUpstreamMsgGetResponse;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

import java.util.Date;

/**
 * 获取消息发送周数据（getupstreammsgweek）
 * 30
 * https://api.weixin.qq.com/datacube/getupstreammsgweek?access_token=ACCESS_TOKEN
 * Created by lemon_bar on 15/7/29.
 */
public class WXUpstreamMsgWeekGetRequest extends WXRequest<WXUpstreamMsgGetResponse> {
    public WXUpstreamMsgWeekGetRequest(String token, Date start, Date end) throws WXException {
        super();
        this.method = WXHTTPMethod.POST;
        this.path = "/datacube/getupstreammsgweek";
        this.parameters.put("access_token", token);
        DatePeriod datePeriod = new DatePeriod(start, end);
        this.body = WXJsonUtil.beanToJson(datePeriod);
    }

    @Override
    public WXUpstreamMsgGetResponse createResponse(String body) throws WXException {
        return WXJsonUtil.jsonToBean(body, WXUpstreamMsgGetResponse.class);
    }
}

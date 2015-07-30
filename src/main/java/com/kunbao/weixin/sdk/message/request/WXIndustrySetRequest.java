package com.kunbao.weixin.sdk.message.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import com.kunbao.weixin.sdk.message.domain.template.Industry;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

/**
 * http请求方式: POST
 * https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN
 * Created by lemon_bar on 15/7/30.
 */
public class WXIndustrySetRequest extends WXRequest<WXJsonResponse> {
    public WXIndustrySetRequest(String token, Industry industry) throws WXException {
        super();
        this.method = WXHTTPMethod.POST;
        this.path = "/cgi-bin/template/api_set_industry";
        this.addParameter("access_token", token);
        this.body = WXJsonUtil.beanToJson(industry);
    }

    @Override
    public WXJsonResponse createResponse(String body) throws WXException {
        return WXJsonUtil.jsonToBean(body, WXJsonResponse.class);
    }
}

package com.kunbao.weixin.sdk.management.material.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import com.kunbao.weixin.sdk.management.material.domain.NewsUpdater;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

/**
 * http请求方式: POST
 * https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=ACCESS_TOKEN
 * Created by lemon_bar on 15/7/24.
 */
public class WXUpdateNewsRequest extends WXRequest<WXJsonResponse> {
    public WXUpdateNewsRequest(String token, NewsUpdater newsUpdater) throws WXException {
        super();
        this.method = WXHTTPMethod.POST;
        this.path = "/cgi-bin/material/update_news";
        this.parameters.put("access_token", token);
        this.body = WXJsonUtil.beanToJson(newsUpdater);
    }

    @Override
    public WXJsonResponse createResponse(String body) throws WXException {
        return WXJsonUtil.jsonToBean(body, WXJsonResponse.class);
    }
}

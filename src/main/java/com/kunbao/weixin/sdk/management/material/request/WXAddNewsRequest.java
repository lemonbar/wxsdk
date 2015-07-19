package com.kunbao.weixin.sdk.management.material.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.management.material.domain.NewsList;
import com.kunbao.weixin.sdk.management.material.response.WXAddNewsResponse;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

/**
 * http请求方式: POST
 * https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN
 * Created by lemon_bar on 15/7/12.
 */
public class WXAddNewsRequest extends WXRequest<WXAddNewsResponse> {
    public WXAddNewsRequest(String token, NewsList newsList) {
        super();
        this.method = WXHTTPMethod.POST;
        this.path = "/cgi-bin/material/add_news";
        this.parameters.put("access_token", token);
        this.body = WXJsonUtil.beanToJson(newsList);
    }

    @Override
    public WXAddNewsResponse createResponse(String body) {
        return WXJsonUtil.jsonToBean(body, WXAddNewsResponse.class);
    }
}

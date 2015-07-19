package com.kunbao.weixin.sdk.management.menu.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import com.kunbao.weixin.sdk.management.menu.domain.Menu;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

/**
 * Created by lemon_bar on 15/7/7.
 */
public class WXMenuCreateRequest extends WXRequest<WXJsonResponse> {

    public WXMenuCreateRequest(String token, Menu menu) {
        super();
        this.method = WXHTTPMethod.POST;
        this.path = "/cgi-bin/menu/create";
        this.addParameter("access_token", token);
        this.body = WXJsonUtil.beanToJson(menu);
    }

    @Override
    public WXJsonResponse createResponse(String body) {
        return WXJsonUtil.jsonToBean(body, WXJsonResponse.class);
    }
}

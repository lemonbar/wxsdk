package com.kunbao.weixin.sdk.management.menu.request;

import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.management.menu.response.WXMenuGetResponse;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

/**
 * Created by lemon_bar on 15/7/7.
 */
public class WXMenuGetRequest extends WXRequest<WXMenuGetResponse> {

    public WXMenuGetRequest(String token) {
        super();
        this.path = "/cgi-bin/menu/get";
        this.addParameter("access_token", token);
    }

    @Override
    public WXMenuGetResponse createResponse(String body) {
        return WXJsonUtil.jsonToBean(body, WXMenuGetResponse.class);
    }
}

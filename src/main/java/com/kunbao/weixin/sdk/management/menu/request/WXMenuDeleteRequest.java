package com.kunbao.weixin.sdk.management.menu.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

/**
 * Created by lemon_bar on 15/7/10.
 */
public class WXMenuDeleteRequest extends WXRequest<WXJsonResponse> {

    public WXMenuDeleteRequest(String token) {
        super();
        this.method = WXHTTPMethod.GET;
        this.path = "/cgi-bin/menu/delete";
        this.addParameter("access_token", token);
    }

    @Override
    public WXJsonResponse createResponse(String body) throws WXException {
        return WXJsonUtil.jsonToBean(body, WXJsonResponse.class);
    }
}

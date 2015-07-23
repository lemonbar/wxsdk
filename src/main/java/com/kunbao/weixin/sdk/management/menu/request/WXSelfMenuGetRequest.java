package com.kunbao.weixin.sdk.management.menu.request;

import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.management.menu.response.WXSelfMenuGetResponse;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

/**
 * Created by lemon_bar on 15/7/7.
 */
public class WXSelfMenuGetRequest extends WXRequest<WXSelfMenuGetResponse> {

    public WXSelfMenuGetRequest(String token) {
        super();
        this.path = "/cgi-bin/get_current_selfmenu_info";
        this.addParameter("access_token", token);
    }

    @Override
    public WXSelfMenuGetResponse createResponse(String body) throws WXException {
        return WXJsonUtil.jsonToBean(body, WXSelfMenuGetResponse.class);
    }
}

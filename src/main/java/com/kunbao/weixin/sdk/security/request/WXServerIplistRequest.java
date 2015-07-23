package com.kunbao.weixin.sdk.security.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.security.response.WXServerIpListResponse;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

/**
 * Created by lemon_bar on 15/7/23.
 */
public class WXServerIplistRequest extends WXRequest<WXServerIpListResponse> {
    public WXServerIplistRequest(String token) {
        super();
        this.method = WXHTTPMethod.GET;
        this.path = "/cgi-bin/getcallbackip";
        this.addParameter("access_token", token);
    }

    @Override
    public WXServerIpListResponse createResponse(String body) {
        return WXJsonUtil.jsonToBean(body, WXServerIpListResponse.class);
    }
}

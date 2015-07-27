package com.kunbao.weixin.sdk.management.oauth2.request;

import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

/**
 * http：GET（请使用https协议）
 * https://api.weixin.qq.com/sns/auth?access_token=ACCESS_TOKEN&openid=OPENID
 * Created by lemon_bar on 15/7/27.
 */
public class WXOAuthTokenCheckRequest extends WXRequest<WXJsonResponse> {
    public WXOAuthTokenCheckRequest(String token, String openId) {
        super();
        this.path = "/sns/auth";
        this.parameters.put("access_token", token);
        this.parameters.put("openid", openId);
    }

    @Override
    public WXJsonResponse createResponse(String body) throws WXException {
        return WXJsonUtil.jsonToBean(body, WXJsonResponse.class);
    }
}

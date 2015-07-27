package com.kunbao.weixin.sdk.management.oauth2.request;


import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.management.oauth2.response.WXOAuthUserResponse;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

/**
 * Created by baylor on 15/7/25.
 */
public class WXOAuthUserRequest extends WXRequest<WXOAuthUserResponse> {

    public WXOAuthUserRequest(String accessToken, String openId, String lang) {
        super();
        this.path = "/sns/userinfo";
        this.addParameter("access_token", accessToken);
        this.addParameter("openid", openId);
        this.addParameter("lang", lang);
    }

    @Override
    public WXOAuthUserResponse createResponse(String body) throws WXException {
        return WXJsonUtil.jsonToBean(body, WXOAuthUserResponse.class);
    }
}

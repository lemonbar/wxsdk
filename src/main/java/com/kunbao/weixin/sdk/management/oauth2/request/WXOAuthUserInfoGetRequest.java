package com.kunbao.weixin.sdk.management.oauth2.request;


import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.management.oauth2.response.WXOAuthUserInfoGetResponse;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

/**
 * Created by baylor on 15/7/25.
 */
public class WXOAuthUserInfoGetRequest extends WXRequest<WXOAuthUserInfoGetResponse> {

    public WXOAuthUserInfoGetRequest(String accessToken, String openId, String lang) {
        super();
        this.path = "/sns/userinfo";
        this.addParameter("access_token", accessToken);
        this.addParameter("openid", openId);
        this.addParameter("lang", lang);
    }

    @Override
    public WXOAuthUserInfoGetResponse createResponse(String body) throws WXException {
//        System.out.println(body);
        return WXJsonUtil.jsonToBean(body, WXOAuthUserInfoGetResponse.class);
    }
}

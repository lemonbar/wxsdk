package com.kunbao.weixin.sdk.management.oauth2.request;


import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.management.oauth2.response.WXOAuthTokenGetResponse;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

/**
 * Created by baylor on 15/7/25.
 */
public class WXOAuthTokenGetRequest extends WXRequest<WXOAuthTokenGetResponse> {

    private final static String GRANT_TYPE_DEFAULT = "authorization_code";

    public WXOAuthTokenGetRequest(String appId, String appSecret, String code) {
        super();
        this.path = "/sns/oauth2/access_token";
        this.addParameter("grant_type", GRANT_TYPE_DEFAULT);
        this.addParameter("appid", appId);
        this.addParameter("secret", appSecret);
        this.addParameter("code", code);
    }

    @Override
    public WXOAuthTokenGetResponse createResponse(String body) throws WXException {
        return WXJsonUtil.jsonToBean(body, WXOAuthTokenGetResponse.class);
    }
}

package com.kunbao.weixin.sdk.management.user.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.management.user.domain.WXLang;
import com.kunbao.weixin.sdk.management.user.response.WXUserInfoResponse;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

/**
 * http请求方式: GET
 * https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
 * Created by lemon_bar on 15/7/22.
 */
public class WXUserInfoRequest extends WXRequest<WXUserInfoResponse> {
    public WXUserInfoRequest(String token, String openId, WXLang lang) {
        super();
        this.method = WXHTTPMethod.GET;
        this.path = "/cgi-bin/user/info";
        this.addParameter("access_token", token);
        this.addParameter("openid", openId);
        this.addParameter("lang", lang.toString());
    }

    @Override
    public WXUserInfoResponse createResponse(String body) throws WXException {
        return WXJsonUtil.jsonToBean(body, WXUserInfoResponse.class);
    }
}

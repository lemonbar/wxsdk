package com.kunbao.weixin.sdk.management.user.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.management.user.response.WXUserGetResponse;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

/**
 * https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID
 * Created by lemon_bar on 15/7/22.
 */
public class WXUserGetRequest extends WXRequest<WXUserGetResponse> {
    public WXUserGetRequest(String token, String nextOpenId) {
        super();
        this.method = WXHTTPMethod.GET;
        this.path = "/cgi-bin/user/get";
        this.addParameter("access_token", token);
        this.addParameter("next_openid", nextOpenId);
    }

    @Override
    public WXUserGetResponse createResponse(String body) throws WXException {
        return WXJsonUtil.jsonToBean(body, WXUserGetResponse.class);
    }
}

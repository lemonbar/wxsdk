package com.kunbao.weixin.sdk.management.user.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.management.user.response.WXUserGroupGetResponse;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

/**
 * http请求方式: GET（请使用https协议）
 * https://api.weixin.qq.com/cgi-bin/groups/get?access_token=ACCESS_TOKEN
 * Created by lemon_bar on 15/7/23.
 */
public class WXUserGroupGetRequest extends WXRequest<WXUserGroupGetResponse> {
    public WXUserGroupGetRequest(String token) {
        super();
        this.method = WXHTTPMethod.GET;
        this.path = "/cgi-bin/groups/get";
        this.addParameter("access_token", token);
    }

    @Override
    public WXUserGroupGetResponse createResponse(String body) throws WXException {
        return WXJsonUtil.jsonToBean(body, WXUserGroupGetResponse.class);
    }
}

package com.kunbao.weixin.sdk.management.user.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.management.user.domain.WXUserGroupWrapper;
import com.kunbao.weixin.sdk.management.user.response.WXUserGroupCreateResponse;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

/**
 * http请求方式: POST（请使用https协议）
 * https://api.weixin.qq.com/cgi-bin/groups/create?access_token=ACCESS_TOKEN
 * POST数据格式：json
 * POST数据例子：{"group":{"name":"test"}}
 * Created by lemon_bar on 15/7/23.
 */
public class WXUserGroupCreateRequest extends WXRequest<WXUserGroupCreateResponse> {
    public WXUserGroupCreateRequest(String token, WXUserGroupWrapper group) throws WXException {
        super();
        this.method = WXHTTPMethod.POST;
        this.path = "/cgi-bin/groups/create";
        this.addParameter("access_token", token);
        this.body = WXJsonUtil.beanToJson(group);
    }

    @Override
    public WXUserGroupCreateResponse createResponse(String body) throws WXException {
        return WXJsonUtil.jsonToBean(body, WXUserGroupCreateResponse.class);
    }
}

package com.kunbao.weixin.sdk.management.user.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.management.user.domain.WXOpenId;
import com.kunbao.weixin.sdk.management.user.response.WXUserGroupGetIdResponse;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

/**
 * http请求方式: POST（请使用https协议）
 * https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=ACCESS_TOKEN
 * POST数据格式：json
 * POST数据例子：{"openid":"od8XIjsmk6QdVTETa9jLtGWA6KBc"}
 * Created by lemon_bar on 15/7/23.
 */
public class WXUserGroupGetIdRequest extends WXRequest<WXUserGroupGetIdResponse> {
    public WXUserGroupGetIdRequest(String token, String openId) throws WXException {
        super();
        this.method = WXHTTPMethod.POST;
        this.path = "/cgi-bin/groups/getid";
        this.addParameter("access_token", token);
        WXOpenId wxOpenId = new WXOpenId(openId);
        this.body = WXJsonUtil.beanToJson(wxOpenId);
    }

    @Override
    public WXUserGroupGetIdResponse createResponse(String body) throws WXException {
        return WXJsonUtil.jsonToBean(body, WXUserGroupGetIdResponse.class);
    }
}

package com.kunbao.weixin.sdk.management.user.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.management.user.domain.WXUserList;
import com.kunbao.weixin.sdk.management.user.response.WXUserInfoListResponse;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

/**
 * http请求方式: POST
 * https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN
 * Created by lemon_bar on 15/7/24.
 */
public class WXUserInfoBatchRequest extends WXRequest<WXUserInfoListResponse> {
    public WXUserInfoBatchRequest(String token, WXUserList userList) throws WXException {
        super();
        this.method = WXHTTPMethod.POST;
        this.path = "/cgi-bin/user/info/batchget";
        this.addParameter("access_token", token);
        this.body = WXJsonUtil.beanToJson(userList);
    }

    @Override
    public WXUserInfoListResponse createResponse(String body) throws WXException {
        return WXJsonUtil.jsonToBean(body, WXUserInfoListResponse.class);
    }
}

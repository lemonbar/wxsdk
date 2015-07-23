package com.kunbao.weixin.sdk.management.user.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import com.kunbao.weixin.sdk.management.user.domain.WXRemarkUser;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

/**
 * http请求方式: POST（请使用https协议）
 * https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=ACCESS_TOKEN
 * POST数据格式：JSON
 * POST数据例子：
 * {
 * "openid":"oDF3iY9ffA-hqb2vVvbr7qxf6A0Q",
 * "remark":"pangzi"
 * }
 * Created by lemon_bar on 15/7/24.
 */
public class WXUserRemarkRequest extends WXRequest<WXJsonResponse> {
    public WXUserRemarkRequest(String token, String openId, String remark) throws WXException {
        super();
        WXRemarkUser remarkUser = new WXRemarkUser(openId, remark);
        this.method = WXHTTPMethod.POST;
        this.path = "/cgi-bin/user/info/updateremark";
        this.addParameter("access_token", token);
        this.body = WXJsonUtil.beanToJson(remarkUser);
    }

    @Override
    public WXJsonResponse createResponse(String body) throws WXException {
        return WXJsonUtil.jsonToBean(body, WXJsonResponse.class);
    }
}

package com.kunbao.weixin.sdk.management.user.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import com.kunbao.weixin.sdk.management.user.domain.WXUserBatchMove;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

/**
 * http请求方式: POST（请使用https协议）
 * https://api.weixin.qq.com/cgi-bin/groups/members/batchupdate?access_token=ACCESS_TOKEN
 * POST数据格式：json
 * POST数据例子：{"openid_list":["oDF3iYx0ro3_7jD4HFRDfrjdCM58","oDF3iY9FGSSRHom3B-0w5j4jlEyY"],"to_groupid":108}
 * Created by lemon_bar on 15/7/24.
 */
public class WXUserBatchMoveGroupRequest extends WXRequest<WXJsonResponse> {
    public WXUserBatchMoveGroupRequest(String token, WXUserBatchMove batchMove) throws WXException {
        super();
        this.method = WXHTTPMethod.POST;
        this.path = "/cgi-bin/groups/members/batchupdate";
        this.addParameter("access_token", token);
        this.body = WXJsonUtil.beanToJson(batchMove);
    }

    @Override
    public WXJsonResponse createResponse(String body) throws WXException {
        return WXJsonUtil.jsonToBean(body, WXJsonResponse.class);
    }
}

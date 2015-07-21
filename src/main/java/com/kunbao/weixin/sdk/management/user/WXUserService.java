package com.kunbao.weixin.sdk.management.user;

import com.kunbao.weixin.sdk.base.WXHttpDispatch;
import com.kunbao.weixin.sdk.management.user.request.WXUserGetRequest;
import com.kunbao.weixin.sdk.management.user.request.WXUserInfoRequest;
import com.kunbao.weixin.sdk.management.user.response.WXUserGetResponse;
import com.kunbao.weixin.sdk.management.user.response.WXUserInfoResponse;
import com.kunbao.weixin.sdk.token.WXTokenController;

/**
 * Created by lemon_bar on 15/7/22.
 */
public class WXUserService {
    public WXUserGetResponse getUserList(String nextOpenId) {
        WXUserGetRequest request = new WXUserGetRequest(WXTokenController.getToken(), nextOpenId);
        WXUserGetResponse response = (WXUserGetResponse) WXHttpDispatch.execute(request);
        return response;
    }

    public WXUserInfoResponse getUserInfo(String openId, String lang) {
        WXUserInfoRequest request = new WXUserInfoRequest(WXTokenController.getToken(), openId, lang);
        WXUserInfoResponse response = (WXUserInfoResponse) WXHttpDispatch.execute(request);
        return response;
    }
}

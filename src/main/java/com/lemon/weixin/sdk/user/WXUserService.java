package com.lemon.weixin.sdk.user;

import com.lemon.weixin.sdk.user.resp.WXUserInfo;
import com.lemon.weixin.sdk.util.WXHttpUtil;
import com.lemon.weixin.sdk.base.constants.WXApiUrl;
import com.lemon.weixin.sdk.user.resp.WXUserPage;
import com.lemon.weixin.sdk.util.WXJsonUtil;

/**
 * Created by lemon_bar on 2014/12/4.
 */
public class WXUserService {

    public WXUserPage getUserList(String accessToken, String firstOpenId) {
        String url = WXApiUrl.getUserListUrl(accessToken, firstOpenId);
        String response = WXHttpUtil.doGet(url);

        if (response != null) {
            return WXJsonUtil.jsonToBean(response, WXUserPage.class);
        }

        return null;
    }

    public WXUserInfo getUserInfo(String accessToken, String openId) {
        String url = WXApiUrl.getUserInfoUrl(accessToken, openId);
        String response = WXHttpUtil.doGet(url);

        if (response != null) {
            return WXJsonUtil.jsonToBean(response, WXUserInfo.class);
        }

        return null;
    }
}

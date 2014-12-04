package com.lemon.weixin.sdk.user;

import com.lemon.weixin.sdk.base.WXHttpService;
import com.lemon.weixin.sdk.constants.WXApiUrl;
import com.lemon.weixin.sdk.user.model.WXUserPage;
import com.lemon.weixin.sdk.util.WXAccessTokenUtil;
import com.lemon.weixin.sdk.util.WXJsonUtil;

/**
 * Created by lemon_bar on 2014/12/4.
 */
public class WXUserService {
    public static void getUserList() {
        String url = WXApiUrl.getUserListUrl(WXAccessTokenUtil.getToken(), "");
        String response = WXHttpService.responseWithURL(url);

        if (response != null) {
            WXUserPage userPage = WXJsonUtil.jsonToBean(response, WXUserPage.class);
            System.out.println("xxx");
        }
    }

    //only for test.
    public static void main(String... args) {
        getUserList();
    }
}

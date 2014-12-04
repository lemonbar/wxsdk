package com.lemon.weixin;

import com.lemon.weixin.sdk.base.WXTokenService;
import com.lemon.weixin.sdk.user.WXUserService;
import com.lemon.weixin.sdk.user.model.WXUserPage;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        WXTokenService tokenService = new WXTokenService();
        WXUserService userService = new WXUserService();

        String token = tokenService.getAccessToken();
        WXUserPage wxUserPage = userService.getUserList(token, "");

        if (wxUserPage != null && wxUserPage.getData().getOpenid() != null) {
            List<String> openIdList = wxUserPage.getData().getOpenid();
        }

        System.out.println("Hello World!");


    }
}

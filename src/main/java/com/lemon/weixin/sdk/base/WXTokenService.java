package com.lemon.weixin.sdk.base;

import com.lemon.weixin.sdk.base.constants.WXApiUrl;
import com.lemon.weixin.sdk.util.WXAccessTokenUtil;
import com.lemon.weixin.sdk.util.WXHttpUtil;

/**
 * Created by lemon_bar on 14-12-4.
 */
public class WXTokenService {
    public String getAccessToken() {
        if (WXAccessTokenUtil.isTokenAvailable()) {
            return WXAccessTokenUtil.getToken();
        } else {
            String response = WXHttpUtil.responseWithURL(WXApiUrl.getBaseTokenUrl());
            if (response != null) {
                return WXAccessTokenUtil.parseAndStoreAccessToken(response);
            }
        }
        return null;
    }

    public String refreshAccessToken() {
        String response = WXHttpUtil.responseWithURL(WXApiUrl.getBaseTokenUrl());
        if (response != null) {
            return WXAccessTokenUtil.parseAndStoreAccessToken(response);
        }
        return null;
    }
}

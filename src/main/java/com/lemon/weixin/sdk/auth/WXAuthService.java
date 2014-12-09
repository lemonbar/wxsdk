package com.lemon.weixin.sdk.auth;

import com.google.gson.Gson;
import com.lemon.weixin.sdk.auth.resp.WXAuthToken;
import com.lemon.weixin.sdk.util.WXHttpUtil;
import com.lemon.weixin.sdk.base.constants.WXApiUrl;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * Created by lemon_bar on 14-12-2.
 */
public class WXAuthService {
    private WXAuthToken authToken;

    private synchronized WXAuthToken getAuthToken(String code) {
        String response = null;
        if (authToken == null) {
            response = WXHttpUtil.doGet(WXApiUrl.getAuthTokenUrl(code));
        } else if (StringUtils.isNotBlank(authToken.getRefresh_token()) && authToken.isExpired()) {
            response = WXHttpUtil.doGet(WXApiUrl.getAuthTokenRefreshUrl(authToken.getRefresh_token()));
        }
        if (response != null) {
            authToken = new Gson().fromJson(response, WXAuthToken.class);
            authToken.setCreateDate(new Date());
        } else {
            //todo log the error
            return null;
        }
        return authToken;
    }

    public String getOpenId(String code) {
        return getAuthToken(code).getOpenid();
    }
}

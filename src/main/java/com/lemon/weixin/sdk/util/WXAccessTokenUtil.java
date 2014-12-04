package com.lemon.weixin.sdk.util;

import com.lemon.weixin.sdk.base.constants.WXApiUrl;
import lombok.Data;

import java.util.Date;

/**
 * Created by lemon_bar on 2014/12/4.
 */
public class WXAccessTokenUtil {

    private static AccessToken accessToken;

    public synchronized static String parseAndStoreAccessToken(String jsonStr) {
        accessToken = WXJsonUtil.jsonToBean(jsonStr, AccessToken.class);
        accessToken.setCreateDate(new Date());
        return accessToken.getAccess_token();
    }

    public static boolean isTokenAvailable() {
        return (accessToken != null && !accessToken.isExpired());
    }

    public static String getToken() {
        return accessToken.getAccess_token();
    }

    @Data
    private class AccessToken {
        private String access_token;
        private long expires_in;
        private Date createDate;

        public boolean isExpired() {
            //To make sure the token is available,
            // invalid the token 10 minutes in advance;
            return createDate.getTime() + expires_in * 1000 < new Date().getTime() - 10 * 60 * 1000;
        }
    }
}

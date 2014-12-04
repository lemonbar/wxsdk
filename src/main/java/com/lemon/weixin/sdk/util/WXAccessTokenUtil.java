package com.lemon.weixin.sdk.util;

import com.lemon.weixin.sdk.base.WXHttpService;
import com.lemon.weixin.sdk.constants.WXApiUrl;
import lombok.Data;

import java.util.Date;

/**
 * Created by lemon_bar on 2014/12/4.
 */
public class WXAccessTokenUtil {

    private static AccessToken accessToken;

    public synchronized static String getToken() {
//        return "LpY4SBBNTNnrWZ4AUzgr6W5kvmRIpqYHy4bW1R1x8ubGjtqasizY9k6LliWNStokxgQiOssgdk_5fOBcyrMPX5aezjm35VdIu7t8TRU8Thw";
        if (accessToken == null || accessToken.isExpired()) {
            String response = WXHttpService.responseWithURL(WXApiUrl.getBaseTokenUrl());
            if (response != null) {
                accessToken = WXJsonUtil.jsonToBean(response, AccessToken.class);
                accessToken.setCreateDate(new Date());
            } else {
                //todo log the error
                return null;
            }
        }
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

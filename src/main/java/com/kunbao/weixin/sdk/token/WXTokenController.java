package com.kunbao.weixin.sdk.token;

import com.kunbao.weixin.sdk.base.WXHttpDispatch;
import com.kunbao.weixin.sdk.base.domain.constant.WXAppConstant;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.token.request.WXTokenRequest;
import com.kunbao.weixin.sdk.token.response.WXTokenResponse;
import lombok.Data;

import java.util.Date;

/**
 * Created by lemon_bar on 15/7/7.
 */
public class WXTokenController {
    private static AccessToken accessToken;

    public synchronized static void parseAndStoreAccessToken() throws WXException {
        if (!isTokenAvailable()) {
            //get access token.
            WXTokenRequest request = new WXTokenRequest(WXAppConstant.APP_ID, WXAppConstant.APP_SECRET);
            WXTokenResponse response = (WXTokenResponse) WXHttpDispatch.execute(request);
            //store
            accessToken = new AccessToken();
            accessToken.setAccess_token(response.getAccessToken());
            accessToken.setExpires_in(response.getExpires());
            accessToken.setCreateDate(new Date());
            System.out.println(String.format("refresh access token:{value:%s,expires_in:%d}", accessToken.access_token, accessToken.expires_in));
        }
    }

    public static boolean isTokenAvailable() {
        return (accessToken != null && !accessToken.isExpired());
    }

    public static String getToken() throws WXException {
        if (!isTokenAvailable()) {
            parseAndStoreAccessToken();
        }
        return accessToken.getAccess_token();
    }

    @Data
    private static class AccessToken {
        private String access_token;
        private long expires_in;
        private Date createDate;

        public boolean isExpired() {
            //To make sure the token is available,
            // invalid the token 10 minutes in advance;
            Date date = new Date();
            long remainingTime = createDate.getTime() + expires_in * 1000 - date.getTime();
            long seconds = remainingTime / 1000;
            return seconds < 10 * 60;
        }
    }
}

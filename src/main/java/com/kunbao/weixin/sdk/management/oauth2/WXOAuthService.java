package com.kunbao.weixin.sdk.management.oauth2;

import com.kunbao.weixin.sdk.base.WXHttpDispatch;
import com.kunbao.weixin.sdk.base.domain.constant.WXAppConstant;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import com.kunbao.weixin.sdk.management.oauth2.domain.WXOAuthUrl;
import com.kunbao.weixin.sdk.management.oauth2.request.WXOAuthTokenCheckRequest;
import com.kunbao.weixin.sdk.management.oauth2.request.WXOAuthTokenRefreshRequest;
import com.kunbao.weixin.sdk.management.oauth2.request.WXOAuthTokenGetRequest;
import com.kunbao.weixin.sdk.management.oauth2.request.WXOAuthUserInfoGetRequest;
import com.kunbao.weixin.sdk.management.oauth2.response.WXOAuthTokenRefreshResponse;
import com.kunbao.weixin.sdk.management.oauth2.response.WXOAuthTokenGetResponse;
import com.kunbao.weixin.sdk.management.oauth2.response.WXOAuthUserInfoGetResponse;

/**
 * Created by baylor on 15/7/25.
 */
public class WXOAuthService {

    //        Scope为snsapi_userinfo
//        https://open.weixin.qq.com/connect/oauth2/authorize?
//        appid=wxf0e81c3bee622d60&
//        redirect_uri=http%3A%2F%2Fnba.bluewebgame.com%2Foauth_response.php&
//        response_type=code&
//        scope=snsapi_userinfo&
//        state=STATE
//        #wechat_redirect
    public static String wxAuthUrl(String redirectUri, String scope, String state) {
        return new WXOAuthUrl.Builder().redirectUri(redirectUri).scope(scope).state(state).build().url();
    }

    //access_token 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
    //且期限较短，需要refresh_token来刷新
    public WXOAuthTokenGetResponse getOAuthAccessToken(String authCode) throws WXException {
        WXOAuthTokenGetRequest request = new WXOAuthTokenGetRequest(WXAppConstant.APP_ID, WXAppConstant.APP_SECRET, authCode);
        WXOAuthTokenGetResponse response = (WXOAuthTokenGetResponse) WXHttpDispatch.execute(request);
        return response;
    }

    public WXOAuthTokenRefreshResponse refreshOAuthAccessToken(String refreshToken) throws WXException {
        WXOAuthTokenRefreshRequest request = new WXOAuthTokenRefreshRequest(WXAppConstant.APP_ID, refreshToken);
        WXOAuthTokenRefreshResponse response = (WXOAuthTokenRefreshResponse) WXHttpDispatch.execute(request);
        return response;
    }

    public boolean checkOAuthTokenValid(String token, String openId) throws WXException {
        WXOAuthTokenCheckRequest request = new WXOAuthTokenCheckRequest(token, openId);
        WXJsonResponse response = (WXJsonResponse) WXHttpDispatch.execute(request);
        return response.isSuccess();
    }

    public WXOAuthUserInfoGetResponse getAuthUserInfo(String authCode, String lang) throws WXException {
        WXOAuthTokenGetRequest authReq = new WXOAuthTokenGetRequest(WXAppConstant.APP_ID, WXAppConstant.APP_SECRET, authCode);
        WXOAuthTokenGetResponse authResp = (WXOAuthTokenGetResponse) WXHttpDispatch.execute(authReq);

        String accessToken = authResp.getAccessToken();
        String openId = authResp.getOpenId();
        if (lang == null) {
            lang = "zh_CN";
        }

        return getAuthUserInfo(accessToken, openId, lang);
    }

    public WXOAuthUserInfoGetResponse getAuthUserInfo(String accessToken, String openId, String lang) throws WXException {
        WXOAuthUserInfoGetRequest request = new WXOAuthUserInfoGetRequest(accessToken, openId, lang);
        WXOAuthUserInfoGetResponse response = (WXOAuthUserInfoGetResponse) WXHttpDispatch.execute(request);
        return response;
    }
}
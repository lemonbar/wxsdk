package com.kunbao.weixin.sdk.management.oauth2;

import com.kunbao.weixin.sdk.base.WXHttpDispatch;
import com.kunbao.weixin.sdk.base.domain.constant.WXAppConstant;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.management.oauth2.domain.WXOAuthUrl;
import com.kunbao.weixin.sdk.management.oauth2.request.WXOAuthRefreshRequest;
import com.kunbao.weixin.sdk.management.oauth2.request.WXOAuthRequest;
import com.kunbao.weixin.sdk.management.oauth2.request.WXOAuthUserRequest;
import com.kunbao.weixin.sdk.management.oauth2.response.WXOAuthRefreshResponse;
import com.kunbao.weixin.sdk.management.oauth2.response.WXOAuthResponse;
import com.kunbao.weixin.sdk.management.oauth2.response.WXOAuthUserResponse;

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
    public static String wxAuthUrl(String redirectUri, String scope, String state){
        return new WXOAuthUrl.Builder().redirectUri(redirectUri).scope(scope).state(state).build().url();
    }

    //access_token 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
    //且期限较短，需要refresh_token来刷新
    public WXOAuthResponse getOAuthAccessToken(String authCode) throws WXException {
        WXOAuthRequest request = new WXOAuthRequest(WXAppConstant.APP_ID, WXAppConstant.APP_SECRET, authCode);
        WXOAuthResponse response = (WXOAuthResponse) WXHttpDispatch.execute(request);
        return response;
    }

    public WXOAuthRefreshResponse refreshOAuthAccessToken(String refreshToken) throws WXException {
        WXOAuthRefreshRequest request = new WXOAuthRefreshRequest(WXAppConstant.APP_ID, refreshToken);
        WXOAuthRefreshResponse response = (WXOAuthRefreshResponse) WXHttpDispatch.execute(request);
        return response;
    }

    public WXOAuthUserResponse getAuthUserInfo(String authCode, String lang) throws WXException {
        WXOAuthRequest authReq = new WXOAuthRequest(WXAppConstant.APP_ID, WXAppConstant.APP_SECRET, authCode);
        WXOAuthResponse authResp = (WXOAuthResponse) WXHttpDispatch.execute(authReq);

        String accessToken = authResp.getAccessToken();
        String openId = authResp.getOpenId();
        if(lang == null) {
            lang = "zh_CN";
        }

        return getAuthUserInfo(accessToken, openId, lang);
    }

    public WXOAuthUserResponse getAuthUserInfo(String accessToken, String openId, String lang) throws WXException {
        WXOAuthUserRequest request = new WXOAuthUserRequest(accessToken, openId, lang);
        WXOAuthUserResponse response = (WXOAuthUserResponse) WXHttpDispatch.execute(request);
        return response;
    }
}
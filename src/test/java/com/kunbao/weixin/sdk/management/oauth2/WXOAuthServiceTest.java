package com.kunbao.weixin.sdk.management.oauth2;

import com.kunbao.weixin.sdk.management.oauth2.response.WXOAuthUserInfoGetResponse;
import com.kunbao.weixin.sdk.management.user.domain.WXLang;
import junit.framework.TestCase;

/**
 * Created by lemon_bar on 16/1/15.
 */
public class WXOAuthServiceTest extends TestCase {

    private WXOAuthService wxoAuthService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        wxoAuthService = new WXOAuthService();
    }

    public void testWxAuthUrl() throws Exception {
        String url = wxoAuthService.wxAuthUrl("http://wx.likunze.com/activity/detail/1", "snsapi_base", "activity_1");
        System.out.println(url);
    }

    public void testOauth() throws Exception {
        WXOAuthUserInfoGetResponse authInfo = this.wxoAuthService.getAuthUserInfo("", "", "001ee74f03ef493bd4305ab797c02115", WXLang.zh_CN.toString());
        System.out.println(authInfo.getNickName());
    }
}
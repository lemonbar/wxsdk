package com.kunbao.weixin.sdk.token;

import junit.framework.TestCase;

/**
 * Created by lemon_bar on 15/7/7.
 */
public class WXTokenControllerTest extends TestCase {

    public void testGetToken() throws Exception {
        for (int i = 0; i < 10; i++) {
            String accessToken = WXTokenController.getToken();
            System.out.println(accessToken);
        }
    }
}
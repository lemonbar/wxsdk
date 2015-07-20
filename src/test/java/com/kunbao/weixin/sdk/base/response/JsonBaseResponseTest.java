package com.kunbao.weixin.sdk.base.response;

import com.kunbao.weixin.sdk.util.WXJsonUtil;
import junit.framework.TestCase;

/**
 * Created by lemon_bar on 15/7/7.
 */
public class JsonBaseResponseTest extends TestCase {

    public void testConsumeResponse() throws Exception {
        String response = "{\"access_token\":\"ACCESS_TOKEN\",\"expires_in\":7200}";
        WXJsonResponse content = WXJsonUtil.jsonToBean(response, WXJsonResponse.class);
        System.out.println("complete");
    }
}
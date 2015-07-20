package com.kunbao.weixin.sdk.management.account;

import junit.framework.TestCase;

/**
 * Created by lemon_bar on 15/7/10.
 */
public class WXAccountServiceTest extends TestCase {

    public void testCreateTempQrcode() throws Exception {
        long seconds = 10 * 60;
        String qrCodeUrl = WXAccountService.createTempQrcode(seconds, 1);
        System.out.println(qrCodeUrl);
    }
}
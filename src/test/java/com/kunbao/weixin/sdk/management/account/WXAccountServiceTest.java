package com.kunbao.weixin.sdk.management.account;

import junit.framework.TestCase;

/**
 * Created by lemon_bar on 15/7/10.
 */
public class WXAccountServiceTest extends TestCase {
    private WXAccountService wxAccountService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        wxAccountService = new WXAccountService();
    }

    public void testCreateTempQrcode() throws Exception {
        long seconds = 10 * 60;
        String qrCodeUrl = wxAccountService.createTempQrcode(seconds, 1);
        System.out.println(qrCodeUrl);
    }

    public void testCreateLimitStrSceneQrCode() throws Exception {
        String qrCodeUrl = this.wxAccountService.createLimitStrSceneQrCode("aaa");
        System.out.println(qrCodeUrl);
    }
}
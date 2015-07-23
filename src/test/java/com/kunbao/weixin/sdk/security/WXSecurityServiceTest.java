package com.kunbao.weixin.sdk.security;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.List;

/**
 * Created by lemon_bar on 15/7/23.
 */
public class WXSecurityServiceTest extends TestCase {
    private WXSecurityService wxSecurityService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        wxSecurityService = new WXSecurityService();
    }

    public void testGetCallbackIpList() throws Exception {
        List<String> wxCallbackIpList = wxSecurityService.getCallbackIpList();
        Assert.assertNotNull(wxCallbackIpList);
        Assert.assertTrue("Weixin callback ip list size should larger than 0.", wxCallbackIpList.size() > 0);
    }
}
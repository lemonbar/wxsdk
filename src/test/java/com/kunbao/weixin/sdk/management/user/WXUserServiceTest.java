package com.kunbao.weixin.sdk.management.user;

import com.kunbao.weixin.sdk.management.user.domain.WXUserGroup;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.List;

/**
 * Created by lemon_bar on 15/7/23.
 */
public class WXUserServiceTest extends TestCase {
    private WXUserService wxUserService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        wxUserService = new WXUserService();
    }

    public void testCreateUserGroup() throws Exception {
        WXUserGroup userGroup = this.wxUserService.createUserGroup("test");
        Assert.assertNotNull("created user group should not be null.", userGroup);
    }

    public void testGetUserGroup() throws Exception {
        List<WXUserGroup> userGroups = this.wxUserService.getUserGroup();
        Assert.assertNotNull(userGroups);
    }

    public void testDeleteUseGroup() throws Exception {
        boolean result = this.wxUserService.deleteUseGroup(100);
        Assert.assertTrue("delete successfully", result);
    }
}
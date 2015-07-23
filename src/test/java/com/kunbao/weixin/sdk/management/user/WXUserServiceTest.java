package com.kunbao.weixin.sdk.management.user;

import com.google.common.collect.Lists;
import com.kunbao.weixin.sdk.management.user.domain.WXLang;
import com.kunbao.weixin.sdk.management.user.domain.WXUser;
import com.kunbao.weixin.sdk.management.user.domain.WXUserGroup;
import com.kunbao.weixin.sdk.management.user.domain.WXUserList;
import com.kunbao.weixin.sdk.management.user.response.WXUserGetResponse;
import com.kunbao.weixin.sdk.management.user.response.WXUserInfoListResponse;
import com.kunbao.weixin.sdk.management.user.response.WXUserInfoResponse;
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

    public void testGetUserList() throws Exception {
        WXUserGetResponse response = this.wxUserService.getUserList("");
        Assert.assertNotNull(response);
    }

    public void testGetUserInfo() throws Exception {
        WXUserInfoResponse response = this.wxUserService.getUserInfo("o6RpjuNK0fYj1-aBW25aWK7D5cgs", WXLang.zh_CN);
        Assert.assertNotNull(response);
    }

    public void testGetBatchUserInfo() throws Exception {
        WXUser wxUser = new WXUser("o6RpjuNK0fYj1-aBW25aWK7D5cgs", WXLang.zh_CN);
        List<WXUser> userList = Lists.newArrayList();
        userList.add(wxUser);
        WXUserList list = new WXUserList(userList);
        WXUserInfoListResponse response = this.wxUserService.getBatchUserInfo(list);
        Assert.assertNotNull(response);
    }
}
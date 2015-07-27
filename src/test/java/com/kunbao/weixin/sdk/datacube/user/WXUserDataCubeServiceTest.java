package com.kunbao.weixin.sdk.datacube.user;

import com.kunbao.weixin.sdk.base.domain.constant.WXAppConstant;
import com.kunbao.weixin.sdk.datacube.user.domain.UserSummaryItem;
import junit.framework.TestCase;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by lemon_bar on 15/7/27.
 */
public class WXUserDataCubeServiceTest extends TestCase {
    private WXUserDataCubeService userDataCubeService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        WXAppConstant.init("wx4f135cf07185a290", "4b8bffa34e67d63f8a7f080752a36c40", "DNXX2XDF", "UyiZ5eWawdxA6cNbMTwyMKSu9nUDOutrbkDLhbxGULS");
        this.userDataCubeService = new WXUserDataCubeService();
    }

    public void testGetUserSummary() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -5);
        Date start = calendar.getTime();
        calendar.add(Calendar.DATE, 4);
        Date end = calendar.getTime();
        List<UserSummaryItem> result = this.userDataCubeService.getUserSummary(start, end);
        System.out.println(result);
    }
}
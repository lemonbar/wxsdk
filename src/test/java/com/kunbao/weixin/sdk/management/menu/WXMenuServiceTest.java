package com.kunbao.weixin.sdk.management.menu;

import com.kunbao.weixin.sdk.management.menu.domain.Button;
import com.kunbao.weixin.sdk.management.menu.domain.Menu;
import com.kunbao.weixin.sdk.management.menu.domain.ViewButton;
import com.kunbao.weixin.sdk.management.menu.response.WXMenuGetResponse;
import com.kunbao.weixin.sdk.management.menu.response.WXSelfMenuGetResponse;
import com.kunbao.weixin.sdk.management.oauth2.WXOAuthService;
import com.kunbao.weixin.sdk.util.WXJsonUtil;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by lemon_bar on 15/7/7.
 */
public class WXMenuServiceTest extends TestCase {
    private WXMenuService wxMenuService;
    private WXOAuthService wxoAuthService;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        wxMenuService = new WXMenuService();
        wxoAuthService = new WXOAuthService();
    }

    public void testCreateMenu() throws Exception {

        Assert.assertTrue(wxMenuService.deleteMenu());

        Menu menu = new Menu();

//        Button subMenu1 = new ClickButton("医学头条", "newslist");
        Button subMenu1 = new ViewButton("问答", wxoAuthService.wxAuthUrl("http://wx.doctorin.cn/qa/question/list", "snsapi_base", "qa"));
        menu.addButton(subMenu1);

        Button subMenu2 = new ViewButton("人脉", wxoAuthService.wxAuthUrl("http://wx.doctorin.cn/relationship/summary", "snsapi_base", "relationship"));
        menu.addButton(subMenu2);

        Button subMenu3 = new ViewButton("我", wxoAuthService.wxAuthUrl("http://wx.doctorin.cn/mine/menu", "snsapi_base", "mine"));
//        Button subMenu3 = new ClickButton("我", "mineInfo");
//        List<Button> subButtons3 = Lists.newArrayList();
//        subButtons3.add(new ViewButton("我的档案", wxoAuthService.wxAuthUrl("http://likunze.com/mine/profile", "snsapi_base", "mineProfile")));
//        subButtons3.add(new ViewButton("我的提问", wxoAuthService.wxAuthUrl("http://likunze.com/mine/question/list", "snsapi_base", "mineQuestion")));
//        subButtons3.add(new ViewButton("系统消息", wxoAuthService.wxAuthUrl("http://likunze.com/mine/systeminfo/list", "snsapi_base", "mineAlert")));
//        subButtons3.add(new ViewButton("邀请加入", wxoAuthService.wxAuthUrl("http://doctorin.cn/invitation", "snsapi_base", "invitation")));
//        subMenu3.setSubButtons(subButtons3);
        menu.addButton(subMenu3);

        boolean response = wxMenuService.createMenu(menu);
    }

    public void testGetMenu() throws Exception {
        WXMenuGetResponse response = wxMenuService.getMenu();
    }

    public void testGetSelfMenu() throws Exception {
        WXSelfMenuGetResponse response = wxMenuService.getSelfMenu();
        System.out.println(response);

        System.out.println(WXJsonUtil.beanToJson(null));
    }
}
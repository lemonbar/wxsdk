package com.kunbao.weixin.sdk.management.menu;

import com.kunbao.weixin.sdk.management.menu.domain.Button;
import com.kunbao.weixin.sdk.management.menu.domain.ClickButton;
import com.kunbao.weixin.sdk.management.menu.domain.Menu;
import com.kunbao.weixin.sdk.management.menu.domain.ViewButton;
import com.kunbao.weixin.sdk.management.menu.response.WXMenuGetResponse;
import com.kunbao.weixin.sdk.management.menu.response.WXSelfMenuGetResponse;
import junit.framework.TestCase;

/**
 * Created by lemon_bar on 15/7/7.
 */
public class WXMenuServiceTest extends TestCase {

    public void testCreateMenu() throws Exception {
        Menu menu = new Menu();

        Button btn1 = new ClickButton("菜单一", "key1");
        Button btn2 = new ViewButton("菜单二", "http://www.soso.com/");

        menu.addButton(btn1);
        menu.addButton(btn2);

        boolean response = WXMenuService.createMenu(menu);
    }

    public void testGetMenu() throws Exception {
        WXMenuGetResponse response = WXMenuService.getMenu();
    }

    public void testGetSelfMenu() throws Exception {
        WXSelfMenuGetResponse response = WXMenuService.getSelfMenu();
    }
}
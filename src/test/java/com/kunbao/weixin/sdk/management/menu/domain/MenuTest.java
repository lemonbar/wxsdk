package com.kunbao.weixin.sdk.management.menu.domain;

import com.kunbao.weixin.sdk.util.WXJsonUtil;
import junit.framework.TestCase;

/**
 * Created by lemon_bar on 15/7/7.
 */
public class MenuTest extends TestCase {
    public void testFormat() throws Exception {
        Menu menu = new Menu();

        Button btn1 = new ClickButton("菜单一","key1");
        Button btn2 = new ViewButton("菜单二","http://www.soso.com/");

        menu.addButton(btn1);
        menu.addButton(btn2);

        String json = WXJsonUtil.beanToJson(menu);
        System.out.println(json);
    }
}
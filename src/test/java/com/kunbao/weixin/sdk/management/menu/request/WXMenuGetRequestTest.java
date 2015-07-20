package com.kunbao.weixin.sdk.management.menu.request;

import com.kunbao.weixin.sdk.management.menu.response.WXMenuGetResponse;
import com.kunbao.weixin.sdk.util.WXJsonUtil;
import junit.framework.TestCase;

/**
 * Created by lemon_bar on 15/7/7.
 */
public class WXMenuGetRequestTest extends TestCase {

    public void testCreateResponse() throws Exception {
        String menu = "{\"menu\":{\"button\":[{\"type\":\"click\",\"name\":\"今日歌曲\",\"key\":\"V1001_TODAY_MUSIC\",\"sub_button\":[]},{\"type\":\"click\",\"name\":\"歌手简介\",\"key\":\"V1001_TODAY_SINGER\",\"sub_button\":[]},{\"name\":\"菜单\",\"sub_button\":[{\"type\":\"view\",\"name\":\"搜索\",\"url\":\"http://www.soso.com/\",\"sub_button\":[]},{\"type\":\"view\",\"name\":\"视频\",\"url\":\"http://v.qq.com/\",\"sub_button\":[]},{\"type\":\"click\",\"name\":\"赞一下我们\",\"key\":\"V1001_GOOD\",\"sub_button\":[]}]}]}}";

        WXMenuGetResponse response = WXJsonUtil.jsonToBean(menu, WXMenuGetResponse.class);
    }
}
package com.kunbao.weixin.sdk.management.menu;

import com.kunbao.weixin.sdk.base.WXHttpDispatch;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import com.kunbao.weixin.sdk.management.menu.domain.Menu;
import com.kunbao.weixin.sdk.management.menu.request.WXMenuCreateRequest;
import com.kunbao.weixin.sdk.management.menu.request.WXMenuDeleteRequest;
import com.kunbao.weixin.sdk.management.menu.request.WXMenuGetRequest;
import com.kunbao.weixin.sdk.management.menu.request.WXSelfMenuGetRequest;
import com.kunbao.weixin.sdk.management.menu.response.WXMenuGetResponse;
import com.kunbao.weixin.sdk.management.menu.response.WXSelfMenuGetResponse;
import com.kunbao.weixin.sdk.token.WXTokenController;

/**
 * Created by lemon_bar on 15/7/7.
 */
public class WXMenuService {
    public boolean createMenu(Menu menu) throws WXException {
        WXMenuCreateRequest request = new WXMenuCreateRequest(WXTokenController.getToken(), menu);
        WXJsonResponse response = (WXJsonResponse) WXHttpDispatch.execute(request);
        return response.isSuccess();
    }

    public WXMenuGetResponse getMenu() throws WXException {
        WXMenuGetRequest request = new WXMenuGetRequest(WXTokenController.getToken());
        WXMenuGetResponse response = (WXMenuGetResponse) WXHttpDispatch.execute(request);
        return response;
    }

    public WXSelfMenuGetResponse getSelfMenu() throws WXException {
        WXSelfMenuGetRequest request = new WXSelfMenuGetRequest(WXTokenController.getToken());
        WXSelfMenuGetResponse response = (WXSelfMenuGetResponse) WXHttpDispatch.execute(request);
        return response;
    }

    public boolean deleteMenu() throws WXException {
        WXMenuDeleteRequest request = new WXMenuDeleteRequest(WXTokenController.getToken());
        WXJsonResponse response = (WXJsonResponse) WXHttpDispatch.execute(request);
        return response.isSuccess();
    }
}

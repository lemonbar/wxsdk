package com.kunbao.weixin.sdk.datacube.user;

import com.kunbao.weixin.sdk.base.WXHttpDispatch;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.datacube.user.domain.UserSummaryItem;
import com.kunbao.weixin.sdk.datacube.user.request.WXUserSummaryGetRequest;
import com.kunbao.weixin.sdk.datacube.user.response.WXUserSummaryGetResponse;
import com.kunbao.weixin.sdk.token.WXTokenController;

import java.util.Date;
import java.util.List;

/**
 * Created by lemon_bar on 15/7/27.
 */
public class WXUserDataCubeService {
    public List<UserSummaryItem> getUserSummary(Date start, Date end) throws WXException {
        WXUserSummaryGetRequest request = new WXUserSummaryGetRequest(WXTokenController.getToken(), start, end);
        WXUserSummaryGetResponse response = (WXUserSummaryGetResponse) WXHttpDispatch.execute(request);
        return response.getUserSummary();
    }
}

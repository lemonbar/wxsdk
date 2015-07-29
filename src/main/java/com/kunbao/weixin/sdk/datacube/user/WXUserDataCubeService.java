package com.kunbao.weixin.sdk.datacube.user;

import com.kunbao.weixin.sdk.base.WXHttpDispatch;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.datacube.user.domain.UserCumulateItem;
import com.kunbao.weixin.sdk.datacube.user.domain.UserSummaryItem;
import com.kunbao.weixin.sdk.datacube.user.request.WXUserCumulateGetRequest;
import com.kunbao.weixin.sdk.datacube.user.request.WXUserSummaryGetRequest;
import com.kunbao.weixin.sdk.datacube.user.response.WXUserCumulateGetResponse;
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

    public List<UserCumulateItem> getUserCumulate(Date start, Date end) throws WXException {
        WXUserCumulateGetRequest request = new WXUserCumulateGetRequest(WXTokenController.getToken(), start, end);
        WXUserCumulateGetResponse response = (WXUserCumulateGetResponse) WXHttpDispatch.execute(request);
        return response.getUserCumulate();
    }
}

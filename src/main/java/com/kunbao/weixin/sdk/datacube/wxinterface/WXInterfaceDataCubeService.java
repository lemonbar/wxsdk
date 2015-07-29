package com.kunbao.weixin.sdk.datacube.wxinterface;

import com.kunbao.weixin.sdk.base.WXHttpDispatch;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.datacube.wxinterface.domain.InterfaceData;
import com.kunbao.weixin.sdk.datacube.wxinterface.domain.InterfaceHourData;
import com.kunbao.weixin.sdk.datacube.wxinterface.request.WXInterfaceSummaryGetRequest;
import com.kunbao.weixin.sdk.datacube.wxinterface.request.WXInterfaceSummaryHourGetRequest;
import com.kunbao.weixin.sdk.datacube.wxinterface.response.WXInterfaceSummaryGetResponse;
import com.kunbao.weixin.sdk.datacube.wxinterface.response.WXInterfaceSummaryHourGetResponse;
import com.kunbao.weixin.sdk.token.WXTokenController;

import java.util.Date;
import java.util.List;

/**
 * Created by lemon_bar on 15/7/29.
 */
public class WXInterfaceDataCubeService {
    public List<InterfaceData> getInterfaceSummary(Date start, Date end) throws WXException {
        WXInterfaceSummaryGetRequest request = new WXInterfaceSummaryGetRequest(WXTokenController.getToken(), start, end);
        WXInterfaceSummaryGetResponse response = (WXInterfaceSummaryGetResponse) WXHttpDispatch.execute(request);
        return response.getInterfaceData();
    }

    public List<InterfaceHourData> getInterfaceHourSummary(Date start, Date end) throws WXException {
        WXInterfaceSummaryHourGetRequest request = new WXInterfaceSummaryHourGetRequest(WXTokenController.getToken(), start, end);
        WXInterfaceSummaryHourGetResponse response = (WXInterfaceSummaryHourGetResponse) WXHttpDispatch.execute(request);
        return response.getInterfaceHourData();
    }
}

package com.kunbao.weixin.sdk.datacube.message;

import com.kunbao.weixin.sdk.base.WXHttpDispatch;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.datacube.message.domain.UpstreamMsgData;
import com.kunbao.weixin.sdk.datacube.message.domain.UpstreamMsgDistData;
import com.kunbao.weixin.sdk.datacube.message.domain.UpstreamMsgHourData;
import com.kunbao.weixin.sdk.datacube.message.request.*;
import com.kunbao.weixin.sdk.datacube.message.response.WXUpstreamMsgDistGetResponse;
import com.kunbao.weixin.sdk.datacube.message.response.WXUpstreamMsgGetResponse;
import com.kunbao.weixin.sdk.datacube.message.response.WXUpstreamMsgHourGetResponse;
import com.kunbao.weixin.sdk.token.WXTokenController;

import java.util.Date;
import java.util.List;

/**
 * Created by lemon_bar on 15/7/29.
 */
public class WXMessageDataCubeService {
    public List<UpstreamMsgData> getUpstreamMsg(Date start, Date end) throws WXException {
        WXUpstreamMsgGetRequest request = new WXUpstreamMsgGetRequest(WXTokenController.getToken(), start, end);
        WXUpstreamMsgGetResponse response = (WXUpstreamMsgGetResponse) WXHttpDispatch.execute(request);
        return response.getUpstreamMsgData();
    }

    public List<UpstreamMsgHourData> getUpstreamMsgHour(Date start, Date end) throws WXException {
        WXUpstreamMsgHourGetRequest request = new WXUpstreamMsgHourGetRequest(WXTokenController.getToken(), start, end);
        WXUpstreamMsgHourGetResponse response = (WXUpstreamMsgHourGetResponse) WXHttpDispatch.execute(request);
        return response.getUpstreamMsgHourData();
    }

    public List<UpstreamMsgData> getUpstreamMsgWeek(Date start, Date end) throws WXException {
        WXUpstreamMsgWeekGetRequest request = new WXUpstreamMsgWeekGetRequest(WXTokenController.getToken(), start, end);
        WXUpstreamMsgGetResponse response = (WXUpstreamMsgGetResponse) WXHttpDispatch.execute(request);
        return response.getUpstreamMsgData();
    }

    public List<UpstreamMsgData> getUpstreamMsgMonth(Date start, Date end) throws WXException {
        WXUpstreamMsgMonthGetRequest request = new WXUpstreamMsgMonthGetRequest(WXTokenController.getToken(), start, end);
        WXUpstreamMsgGetResponse response = (WXUpstreamMsgGetResponse) WXHttpDispatch.execute(request);
        return response.getUpstreamMsgData();
    }

    public List<UpstreamMsgDistData> getUpstreamMsgDist(Date start, Date end) throws WXException {
        WXUpstreamMsgDistGetRequest request = new WXUpstreamMsgDistGetRequest(WXTokenController.getToken(), start, end);
        WXUpstreamMsgDistGetResponse response = (WXUpstreamMsgDistGetResponse) WXHttpDispatch.execute(request);
        return response.getUpstreamMsgDistData();
    }

    public List<UpstreamMsgDistData> getUpstreamMsgDistWeek(Date start, Date end) throws WXException {
        WXUpstreamMsgDistWeekGetRequest request = new WXUpstreamMsgDistWeekGetRequest(WXTokenController.getToken(), start, end);
        WXUpstreamMsgDistGetResponse response = (WXUpstreamMsgDistGetResponse) WXHttpDispatch.execute(request);
        return response.getUpstreamMsgDistData();
    }

    public List<UpstreamMsgDistData> getUpstreamMsgDistMonth(Date start, Date end) throws WXException {
        WXUpstreamMsgDistMonthGetRequest request = new WXUpstreamMsgDistMonthGetRequest(WXTokenController.getToken(), start, end);
        WXUpstreamMsgDistGetResponse response = (WXUpstreamMsgDistGetResponse) WXHttpDispatch.execute(request);
        return response.getUpstreamMsgDistData();
    }
}

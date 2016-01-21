package com.kunbao.weixin.sdk.jsapiticket.request;

import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.jsapiticket.response.WXJsapiTicketResponse;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

/**
 * Created by lemon_bar on 15/8/30.
 */
public class WXJsapiTicketRequest extends WXRequest<WXJsapiTicketResponse> {
    private final static String TYPE_DEFAULT = "jsapi";

    public WXJsapiTicketRequest(String token) {
        super();
        this.path = "/cgi-bin/ticket/getticket";
        this.addParameter("access_token", token);
        this.addParameter("type", TYPE_DEFAULT);
        // https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi
    }

    @Override
    public WXJsapiTicketResponse createResponse(String body) throws WXException {
        return WXJsonUtil.jsonToBean(body, WXJsapiTicketResponse.class);
    }
}

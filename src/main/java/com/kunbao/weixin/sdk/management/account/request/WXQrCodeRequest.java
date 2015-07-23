package com.kunbao.weixin.sdk.management.account.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.management.account.domain.QrCode;
import com.kunbao.weixin.sdk.management.account.response.WXQrCodeResponse;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

/**
 * Created by lemon_bar on 15/7/10.
 */
public class WXQrCodeRequest extends WXRequest<WXQrCodeResponse> {
    public WXQrCodeRequest(String token, QrCode qrCode) throws WXException {
        super();
        this.method = WXHTTPMethod.POST;
        this.path = "/cgi-bin/qrcode/create";
        this.addParameter("access_token", token);
        this.body = WXJsonUtil.beanToJson(qrCode);
    }

    @Override
    public WXQrCodeResponse createResponse(String body) throws WXException {
        return WXJsonUtil.jsonToBean(body, WXQrCodeResponse.class);
    }
}

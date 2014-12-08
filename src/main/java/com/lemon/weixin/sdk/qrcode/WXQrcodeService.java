package com.lemon.weixin.sdk.qrcode;

import com.lemon.weixin.sdk.base.constants.WXApiUrl;
import com.lemon.weixin.sdk.qrcode.model.WXPermQrcode;
import com.lemon.weixin.sdk.qrcode.model.WXQrcodeTicket;
import com.lemon.weixin.sdk.qrcode.model.WXTempQrcode;
import com.lemon.weixin.sdk.util.WXHttpUtil;
import com.lemon.weixin.sdk.util.WXJsonUtil;

/**
 * Created by limeng0402 on 14-12-7.
 */
public class WXQrcodeService {

    public WXQrcodeTicket createTempQrcode(String accessToken, WXTempQrcode wxTempQrcode) {
        String jsonBody = WXJsonUtil.beanToJson(wxTempQrcode);
        return createQrcode(accessToken, jsonBody);
    }

    public WXQrcodeTicket createPermQrcode(String accessToken, WXPermQrcode wxPermQrcode) {
        String jsonBody = WXJsonUtil.beanToJson(wxPermQrcode);
        return createQrcode(accessToken, jsonBody);
    }

    private WXQrcodeTicket createQrcode(String accessToken, String jsonBody) {
        String url = WXApiUrl.getQrcodeCreateUrl(accessToken);
        String response = WXHttpUtil.doPost(url, jsonBody);
        return WXJsonUtil.jsonToBean(response, WXQrcodeTicket.class);
    }
}

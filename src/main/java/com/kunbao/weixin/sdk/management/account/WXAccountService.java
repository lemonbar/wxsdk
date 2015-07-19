package com.kunbao.weixin.sdk.management.account;

import com.kunbao.weixin.sdk.base.WXHttpDispatch;
import com.kunbao.weixin.sdk.base.domain.constant.WXBaseUrl;
import com.kunbao.weixin.sdk.management.account.domain.Long2ShortAction;
import com.kunbao.weixin.sdk.management.account.domain.QrCode;
import com.kunbao.weixin.sdk.management.account.domain.constant.QrCodeType;
import com.kunbao.weixin.sdk.management.account.request.WXQrCodeRequest;
import com.kunbao.weixin.sdk.management.account.request.WXShortUrlRequest;
import com.kunbao.weixin.sdk.management.account.response.WXQrCodeResponse;
import com.kunbao.weixin.sdk.management.account.response.WXShortUrlResponse;
import com.kunbao.weixin.sdk.token.WXTokenController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by lemon_bar on 15/7/10.
 */
public class WXAccountService {
    private final static String qrCodeUrlPath = "/cgi-bin/showqrcode?ticket=%s";

    public static WXShortUrlResponse long2ShortUrl(Long2ShortAction long2ShortAction) {
        WXShortUrlRequest request = new WXShortUrlRequest(WXTokenController.getToken(), long2ShortAction);
        WXShortUrlResponse response = (WXShortUrlResponse) WXHttpDispatch.execute(request);
        return response;
    }

    public static String createTempQrcode(long expireSeconds, int scenceId) {
        QrCode tempQrCode = new QrCode(expireSeconds, QrCodeType.QR_SCENE, scenceId);
        WXQrCodeRequest request = new WXQrCodeRequest(WXTokenController.getToken(), tempQrCode);
        WXQrCodeResponse response = (WXQrCodeResponse) WXHttpDispatch.execute(request);

        return getQrCodeUrl(response.getTicket());
    }

    public static String createLimitSceneQrCode(long expireSeconds, int scenceId) {
        QrCode limitSceneQrCode = new QrCode(expireSeconds, QrCodeType.QR_LIMIT_SCENE, scenceId);
        WXQrCodeRequest request = new WXQrCodeRequest(WXTokenController.getToken(), limitSceneQrCode);
        WXQrCodeResponse response = (WXQrCodeResponse) WXHttpDispatch.execute(request);

        return getQrCodeUrl(response.getTicket());
    }

    public static String createLimitStrSceneQrCode(long expireSeconds, int scenceId) {
        QrCode limitStrSceneQrCode = new QrCode(expireSeconds, QrCodeType.QR_LIMIT_STR_SCENE, scenceId);
        WXQrCodeRequest request = new WXQrCodeRequest(WXTokenController.getToken(), limitStrSceneQrCode);
        WXQrCodeResponse response = (WXQrCodeResponse) WXHttpDispatch.execute(request);

        return getQrCodeUrl(response.getTicket());
    }

    private static String getQrCodeUrl(String ticket) {
        try {
            return WXBaseUrl.MP + String.format(qrCodeUrlPath, URLEncoder.encode(ticket, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}

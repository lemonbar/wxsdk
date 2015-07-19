package com.kunbao.weixin.sdk.management.account.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kunbao.weixin.sdk.management.account.domain.constant.QrCodeType;
import lombok.Getter;

/**
 * POST数据例子：{"expire_seconds": 604800, "action_name": "QR_SCENE", "action_info": {"scene": {"scene_id": 123}}}
 * Created by lemon_bar on 15/7/10.
 */
@Getter
public class QrCode {
    @JsonProperty("expire_seconds")
    private Long expireSeconds;

    @JsonProperty("action_name")
    private QrCodeType type;

    @JsonProperty("action_info")
    private QrCodeActionInfo actionInfo;

    public static QrCode createTempQrCode(long expireSeconds, int sceneId) {
        QrCode tmpQrCode = new QrCode();
        tmpQrCode.expireSeconds = expireSeconds;
        tmpQrCode.type = QrCodeType.QR_SCENE;
        tmpQrCode.actionInfo = new QrCodeActionInfo(new QrScene(sceneId));
        return tmpQrCode;
    }

    public static QrCode createLimitQrCode(int sceneId) {
        QrCode limitQrCode = new QrCode();
        limitQrCode.expireSeconds = null;
        limitQrCode.type = QrCodeType.QR_LIMIT_SCENE;
        limitQrCode.actionInfo = new QrCodeActionInfo(new QrScene(sceneId));
        return limitQrCode;
    }

    public static QrCode createLimitStrQrCode(String sceneStr) {
        QrCode limitStrQrCode = new QrCode();
        limitStrQrCode.expireSeconds = null;
        limitStrQrCode.type = QrCodeType.QR_LIMIT_STR_SCENE;
        limitStrQrCode.actionInfo = new QrCodeActionInfo(new QrScene(sceneStr));
        return limitStrQrCode;
    }
}

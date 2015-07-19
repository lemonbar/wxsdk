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
    private long expireSeconds;

    @JsonProperty("action_name")
    private QrCodeType type;

    @JsonProperty("action_info")
    private QrCodeActionInfo actionInfo;

    public QrCode(long expireSeconds, QrCodeType type, int sceneId) {
        this.expireSeconds = expireSeconds;
        this.type = type;
        this.actionInfo = new QrCodeActionInfo(new QrScene(sceneId));
    }

    public QrCode(long expireSeconds, QrCodeType type, String sceneStr) {
        this.expireSeconds = expireSeconds;
        this.type = type;
        this.actionInfo = new QrCodeActionInfo(new QrScene(sceneStr));
    }
}

package com.kunbao.weixin.sdk.management.account.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * Created by lemon_bar on 15/7/10.
 */
@Getter
public class QrCodeActionInfo {
    @JsonProperty("scene")
    private QrScene scene;

    public QrCodeActionInfo(QrScene scene) {
        this.scene = scene;
    }
}

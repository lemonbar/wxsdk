package com.lemon.weixin.sdk.qrcode.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * Created by limeng0402 on 14-12-7.
 */
@Data
public class WXTempQrcode {
    private long expire_seconds;
    @Setter(AccessLevel.PRIVATE)
    private String action_name;
    private WXActionInfo action_info;

    public WXTempQrcode(long expire_seconds, WXActionInfo action_info){
        this.expire_seconds = expire_seconds;
        this.action_info = action_info;
        this.action_name = "QR_SCENE";
    }
}
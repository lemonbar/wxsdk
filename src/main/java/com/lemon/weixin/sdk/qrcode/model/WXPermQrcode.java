package com.lemon.weixin.sdk.qrcode.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * Created by limeng0402 on 14-12-7.
 */
@Data
public class WXPermQrcode {
    @Setter(AccessLevel.PRIVATE)
    private String action_name;
    private WXActionInfo action_info;

    public WXPermQrcode(WXActionInfo action_info){
        this.action_info = action_info;
        this.action_name = "QR_LIMIT_SCENE";
    }
}

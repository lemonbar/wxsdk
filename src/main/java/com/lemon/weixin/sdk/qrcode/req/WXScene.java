package com.lemon.weixin.sdk.qrcode.req;

import lombok.Data;

/**
 * Created by limeng0402 on 14-12-7.
 */
@Data
public class WXScene {
    private long scene_id;

    public WXScene(long scene_id) {
        this.scene_id = scene_id;
    }
}
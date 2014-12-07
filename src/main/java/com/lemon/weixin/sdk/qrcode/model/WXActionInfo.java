package com.lemon.weixin.sdk.qrcode.model;

import lombok.Data;

/**
 * Created by limeng0402 on 14-12-7.
 */
@Data
public class WXActionInfo {
    private WXScene scene;

    public WXActionInfo(long scene_id) {
        this.scene = new WXScene(scene_id);
    }
}

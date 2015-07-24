package com.kunbao.weixin.sdk.management.account.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * scene_id	场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
 * scene_str	场景值ID（字符串形式的ID），字符串类型，长度限制为1到64，仅永久二维码支持此字段
 * Created by lemon_bar on 15/7/10.
 */
@Getter
public class QrScene {
    @JsonProperty("scene_id")
    private Integer sceneId;

    @JsonProperty("scene_str")
    private String sceneStr;

    public QrScene(int sceneId) {
        this.sceneId = sceneId;
    }

    public QrScene(String sceneStr) {
        this.sceneStr = sceneStr;
    }
}

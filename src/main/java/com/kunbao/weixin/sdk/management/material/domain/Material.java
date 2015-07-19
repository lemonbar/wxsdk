package com.kunbao.weixin.sdk.management.material.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * Created by lemon_bar on 15/7/12.
 */
@Getter
public class Material {
    @JsonProperty("media_id")
    private String materialId;

    public Material(String materialId) {
        this.materialId = materialId;
    }
}

package com.kunbao.weixin.sdk.management.material.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kunbao.weixin.sdk.management.material.domain.constant.MaterialType;
import lombok.Getter;

/**
 * {
 * "type":TYPE,
 * "offset":OFFSET,
 * "count":COUNT
 * }
 * Created by lemon_bar on 15/7/12.
 */
@Getter
public class MaterialPageableRequest {
    @JsonProperty("type")
    private MaterialType type;
    @JsonProperty("offset")
    private int offset;
    @JsonProperty("count")
    private int count;

    public MaterialPageableRequest(MaterialType type, int offset, int count) {
        this.type = type;
        this.offset = offset;
        this.count = count;
    }
}

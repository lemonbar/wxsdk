package com.kunbao.weixin.sdk.management.user.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * {
 * "group": {
 * "id": 107,
 * "name": "test"
 * }
 * }
 * Created by lemon_bar on 15/7/23.
 */
@Getter
public class WXUserGroup {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    protected WXUserGroup() {
    }

    public WXUserGroup(String name) {
        this.id = null;
        this.name = name;
    }
}

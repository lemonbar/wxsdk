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

    @JsonProperty("count")
    private Integer count;

    protected WXUserGroup() {
        this.id = null;
        this.count = null;
        this.name = null;
    }

    public WXUserGroup(Integer id, String name) {
        this();
        this.id = id;
        this.name = name;
    }

    public WXUserGroup(String name) {
        this();
        this.name = name;
    }

    public WXUserGroup(int id) {
        this();
        this.id = id;
    }
}

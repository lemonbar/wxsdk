package com.kunbao.weixin.sdk.management.user.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * Created by lemon_bar on 15/7/23.
 */
@Getter
public class WXUserGroupWrapper {
    @JsonProperty("group")
    private WXUserGroup group;

    public WXUserGroupWrapper(String name) {
        this.group = new WXUserGroup(name);
    }

    public WXUserGroupWrapper(Integer id, String name) {
        this.group = new WXUserGroup(id, name);
    }
}

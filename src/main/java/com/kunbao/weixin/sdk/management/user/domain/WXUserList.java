package com.kunbao.weixin.sdk.management.user.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by lemon_bar on 15/7/24.
 */
public class WXUserList {
    @JsonProperty("user_list")
    private List<WXUser> userList;

    protected WXUserList() {
    }

    public WXUserList(List<WXUser> userList) {
        this.userList = userList;
    }
}

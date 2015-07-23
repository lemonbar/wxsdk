package com.kunbao.weixin.sdk.management.user.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

/**
 * Created by lemon_bar on 15/7/24.
 */
@Getter
public class WXUserBatchMove {
    @JsonProperty("openid_list")
    private List<String> openIdList;

    @JsonProperty("to_groupid")
    private int groupId;

    public WXUserBatchMove(List<String> openIdList, int groupId) {
        this.openIdList = openIdList;
        this.groupId = groupId;
    }

    protected WXUserBatchMove() {
    }
}

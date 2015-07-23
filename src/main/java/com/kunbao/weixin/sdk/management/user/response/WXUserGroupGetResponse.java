package com.kunbao.weixin.sdk.management.user.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import com.kunbao.weixin.sdk.management.user.domain.WXUserGroup;
import lombok.Getter;

import java.util.List;

/**
 * Created by lemon_bar on 15/7/23.
 */
@Getter
public class WXUserGroupGetResponse extends WXJsonResponse {
    @JsonProperty("groups")
    private List<WXUserGroup> userGroups;
}

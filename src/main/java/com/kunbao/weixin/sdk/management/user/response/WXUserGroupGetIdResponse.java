package com.kunbao.weixin.sdk.management.user.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import lombok.Getter;

/**
 * Created by lemon_bar on 15/7/23.
 */
@Getter
public class WXUserGroupGetIdResponse extends WXJsonResponse {
    @JsonProperty("groupid")
    private int groupId;
}

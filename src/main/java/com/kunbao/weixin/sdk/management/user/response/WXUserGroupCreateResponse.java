package com.kunbao.weixin.sdk.management.user.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import com.kunbao.weixin.sdk.management.user.domain.WXUserGroup;
import lombok.Getter;

/**
 * Created by lemon_bar on 15/7/23.
 */
@Getter
public class WXUserGroupCreateResponse extends WXJsonResponse {
    @JsonProperty("group")
    private WXUserGroup userGroup;
}

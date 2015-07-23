package com.kunbao.weixin.sdk.management.user.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import lombok.Getter;

import java.util.List;

/**
 * Created by lemon_bar on 15/7/24.
 */
@Getter
public class WXUserInfoListResponse extends WXJsonResponse {
    @JsonProperty("user_info_list")
    private List<WXUserInfoResponse> userInfoResponseList;
}

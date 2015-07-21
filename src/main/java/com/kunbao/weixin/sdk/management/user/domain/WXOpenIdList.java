package com.kunbao.weixin.sdk.management.user.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

/**
 * Created by lemon_bar on 15/7/22.
 */
@Getter
public class WXOpenIdList {
    @JsonProperty("openid")
    private List<String> openIdList;
}

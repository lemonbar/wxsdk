package com.kunbao.weixin.sdk.security.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import lombok.Data;

import java.util.List;

/**
 * {
 * "ip_list":["127.0.0.1","127.0.0.1"]
 * }
 * Created by lemon_bar on 15/7/23.
 */
@Data
public class WXServerIpListResponse extends WXJsonResponse {
    @JsonProperty("ip_list")
    private List<String> ipList;
}

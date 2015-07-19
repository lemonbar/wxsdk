package com.kunbao.weixin.sdk.management.menu.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import com.kunbao.weixin.sdk.management.menu.domain.response.MenuRes;
import lombok.Getter;

/**
 * Created by lemon_bar on 15/7/7.
 */
@Getter
public class WXSelfMenuGetResponse extends WXJsonResponse {
    @JsonProperty("is_menu_open")
    private int isOpen;
    @JsonProperty("selfmenu_info")
    private MenuRes selfmenuInfo;
}

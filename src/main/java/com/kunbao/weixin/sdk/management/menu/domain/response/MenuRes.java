package com.kunbao.weixin.sdk.management.menu.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by lemon_bar on 15/7/7.
 */
public class MenuRes {
    @JsonProperty("button")
    private List<ButtonRes> buttons;
}

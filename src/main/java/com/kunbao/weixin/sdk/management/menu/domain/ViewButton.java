package com.kunbao.weixin.sdk.management.menu.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kunbao.weixin.sdk.util.WXJsonUtil;
import lombok.Getter;

/**
 * Created by lemon_bar on 15/7/7.
 */
@Getter
public class ViewButton extends Button {
    @JsonProperty("url")
    private String url;

    public ViewButton(String name, String url) {
        super(name, "view");
        this.url = url;
    }

    @Override
    public String toJson() {
        return WXJsonUtil.beanToJson(this);
    }
}

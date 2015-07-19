package com.kunbao.weixin.sdk.management.menu.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kunbao.weixin.sdk.util.WXJsonUtil;
import lombok.Getter;

/**
 * Created by lemon_bar on 15/7/7.
 */
@Getter
public class ClickButton extends Button {
    @JsonProperty("key")
    private String key;

    public ClickButton(String name, String key) {
        super(name, "click");
        this.key = key;
    }

    @Override
    public String toJson() {
        return WXJsonUtil.beanToJson(this);
    }
}

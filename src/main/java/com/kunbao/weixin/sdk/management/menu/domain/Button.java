package com.kunbao.weixin.sdk.management.menu.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by lemon_bar on 15/7/7.
 */
@Getter
public abstract class Button {
    @JsonProperty("name")
    protected String name;
    @JsonProperty("type")
    protected String type;
    @JsonProperty("sub_button")
    @Setter
    private List<Button> subButtons;

    public Button(String name, String type) {
        this.name = name;
        this.type = type;
        this.subButtons = Lists.newArrayList();
    }

    public abstract String toJson();
}

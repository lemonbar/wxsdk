package com.kunbao.weixin.sdk.management.menu.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

import java.util.List;

/**
 * Created by lemon_bar on 15/10/12.
 */
public class SubButtons {
    @JsonProperty("list")
    @Setter
    private List<ButtonRes> subButtons;
}

package com.lemon.weixin.sdk.base.req;

import lombok.Data;

/**
 * Created by limeng0402 on 14-12-7.
 */
@Data
public class WXShortUrlAction {
    private String action;
    private String long_url;

    public WXShortUrlAction(String long_url){
        this.action = "long2short";
        this.long_url = long_url;
    }
}
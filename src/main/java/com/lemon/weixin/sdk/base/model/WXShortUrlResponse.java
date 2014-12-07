package com.lemon.weixin.sdk.base.model;

import lombok.Data;

/**
 * Created by limeng0402 on 14-12-7.
 */
@Data
public class WXShortUrlResponse {
    private int errcode;
    private String errmsg;
    private String short_url;
}
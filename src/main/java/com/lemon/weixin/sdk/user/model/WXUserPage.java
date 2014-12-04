package com.lemon.weixin.sdk.user.model;

import lombok.Data;

/**
 * Created by lemon_bar on 2014/12/4.
 */
@Data
public class WXUserPage {
    private long total;
    private long count;
    private WXOpenIdList data;
    private String next_openid;
}
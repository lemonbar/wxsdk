package com.lemon.weixin.sdk.auth.resp;

import lombok.Data;

import java.util.Date;

/**
 * Created by lemon_bar on 2014/12/4.
 */
@Data
public class WXAuthToken {
    private String openid;
    private String scope;
    private String access_token;
    private String refresh_token;
    private int expires_in;
    private Date createDate;

    public boolean isExpired() {
        //To make sure the token is available,
        // invalid the token 10 minutes in advance;
        return createDate.getTime() + expires_in * 1000 < new Date().getTime() - 10 * 60 * 1000;
    }
}

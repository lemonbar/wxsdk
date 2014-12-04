package com.lemon.weixin.sdk.auth.model;

/**
 * Created by lemon_bar on 2014/12/4.
 */
public enum WXScope {
    /*
        This scope provide only open id;
     */
    BASIC("snsapi_base"),
    /*
        This scope provide full information access
     */
    DETAIL("snsapi_userinfo");

    private String scope;

    public String getScope() {
        return this.scope;
    }

    private WXScope(String scope) {
        this.scope = scope;
    }
}

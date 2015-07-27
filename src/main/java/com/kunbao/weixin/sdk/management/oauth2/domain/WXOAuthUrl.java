package com.kunbao.weixin.sdk.management.oauth2.domain;

import com.kunbao.weixin.sdk.base.domain.constant.WXAppConstant;

/**
 * Created by baylor on 15/7/26.
 */
public class WXOAuthUrl {

//    String url =  +

    private String baseUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?";
    private String appid;
    private String response_type = "code";
    private String redirect_uri;
    private String scope;
    private String state;
    private String tail = "#wechat_redirect";

    private String url;

    public String url() {
        if (url == null) {
            url = baseUrl + "?" +
                    "appid=" + WXAppConstant.APP_ID + "&" +
                    "response_type="+response_type+"&" +
                    "redirect_uri=" + redirect_uri + "&" +
                    "scope=" + scope + "&" +
                    "state=" + state + "&" +
                    "#wechat_redirect";
        }

        return url;
    }

    private WXOAuthUrl(Builder builder) {
        this.appid = builder.appid;
        this.redirect_uri = builder.redirect_uri;
//        this.response_type = builder.response_type;
        this.scope = builder.scope;
        this.state = builder.state;
    }

    public static class Builder {
        private String appid = WXAppConstant.APP_ID;
        private String response_type;
        private String redirect_uri;
        private String scope;
        private String state;

        public Builder appId(String appid) {
            this.appid = appid;
            return this;
        }

//        public Builder responseType(String response_type) {
//            this.response_type = response_type;
//            return this;
//        }

        public Builder redirectUri(String redirect_uri) {
            this.redirect_uri = redirect_uri;
            return this;
        }

        public Builder scope(String scope) {
            this.scope = scope;
            return this;
        }

        public Builder state(String state) {
            this.state = state;
            return this;
        }


        public WXOAuthUrl build() {
            return new WXOAuthUrl(this);
        }
    }
}

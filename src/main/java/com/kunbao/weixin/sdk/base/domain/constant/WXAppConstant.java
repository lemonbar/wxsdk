package com.kunbao.weixin.sdk.base.domain.constant;

/**
 * Created by lemon_bar on 15/7/23.
 */
public class WXAppConstant {
    public static String TOKEN = "";
    public static String APP_ID = "";
    public static String APP_SECRET = "";
    public static String EncodingAESKey = "";
    public static String DOMAIN_NAME = "";

    public static void init(String appId, String appSecret, String appToken, String encodingAESKey, String domainName) {
        APP_ID = appId;
        APP_SECRET = appSecret;
        TOKEN = appToken;
        EncodingAESKey = encodingAESKey;
        DOMAIN_NAME = domainName;
    }

    public static void init(String appId, String appSecret, String appToken, String encodingAESKey) {
        APP_ID = appId;
        APP_SECRET = appSecret;
        TOKEN = appToken;
        EncodingAESKey = encodingAESKey;
    }
}

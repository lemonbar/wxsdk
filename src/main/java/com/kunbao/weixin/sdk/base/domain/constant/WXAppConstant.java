package com.kunbao.weixin.sdk.base.domain.constant;

/**
 * Created by lemon_bar on 15/7/23.
 */
public class WXAppConstant {
    public static String TOKEN = "XXX";
    public static String APP_ID = "XX";
    public static String APP_SECRET = "XX";
    public static String EncodingAESKey = "XX";

    public static void init(String appId, String appSecret, String appToken, String encodingAESKey) {
        APP_ID = appId;
        APP_SECRET = appSecret;
        TOKEN = appToken;
        EncodingAESKey = encodingAESKey;
    }
}

package com.kunbao.weixin.sdk.base.domain.constant;

/**
 * Created by lemon_bar on 15/7/23.
 */
public class WXAppConstant {
    public static String TOKEN = "DNXX2XDF";
    public static String APP_ID = "wx4f135cf07185a290";
    public static String APP_SECRET = "4b8bffa34e67d63f8a7f080752a36c40";
    public static String EncodingAESKey = "UyiZ5eWawdxA6cNbMTwyMKSu9nUDOutrbkDLhbxGULS";

    public static void init(String appId, String appSecret, String appToken, String encodingAESKey) {
        APP_ID = appId;
        APP_SECRET = appSecret;
        TOKEN = appToken;
        EncodingAESKey = encodingAESKey;
    }
}

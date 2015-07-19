package com.kunbao.weixin.sdk.base.domain.constant;

/**
 * 根据您自己的微信公众号配置信息来设置下面的值。
 * Created by lemon_bar on 15/7/1.
 */
public final class WXConstant {
    public static String TOKEN = "XXXXXX";
    public static String APP_ID = "XXXXXXXX";
    public static String APP_SECRET = "XXXXXXXX";
    public static String EncodingAESKey = "XXXXXXXX";

    public static void init(String appId, String appSecret, String appToken, String encodingAESKey) {
        APP_ID = appId;
        APP_SECRET = appSecret;
        TOKEN = appToken;
        EncodingAESKey = encodingAESKey;
    }
}

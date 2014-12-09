package com.lemon.weixin.sdk.user.resp;

import lombok.Data;

/**
 * Created by limeng0402 on 14-12-4.
 */
@Data
public class WXUserInfo {
    private int subscribe;
    private String openid;
    private String nickname;
    private int sex;
    private String city;
    private String country;
    private String province;
    private String language;
    private String headimgurl;
    private long subscribe_time;
    private String unionid;
}
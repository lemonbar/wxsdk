package com.kunbao.weixin.sdk.management.oauth2.domain;

import lombok.Data;

/**
 * Created by baylor on 15/7/25.
 */
@Data
public class WXOAuthUser {

    private String openId;

    private String nickName;

    private String sex;

    private String province;

    private String city;

    private String country;

    private String headImgUrl;

    private String privilege;

    private String unionId;

}

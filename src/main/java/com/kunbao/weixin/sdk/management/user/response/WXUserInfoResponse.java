package com.kunbao.weixin.sdk.management.user.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import lombok.Getter;

/**
 * {
 * "subscribe": 1,
 * "openid": "o6_bmjrPTlm6_2sgVt7hMZOPfL2M",
 * "nickname": "Band",
 * "sex": 1,
 * "language": "zh_CN",
 * "city": "广州",
 * "province": "广东",
 * "country": "中国",
 * "headimgurl":    "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/0",
 * "subscribe_time": 1382694957,
 * "unionid": " o6_bmasdasdsad6_2sgVt7hMZOPfL"
 * "remark": "",
 * "groupid": 0
 * }
 * Created by lemon_bar on 15/7/22.
 */
@Getter
public class WXUserInfoResponse extends WXJsonResponse {
    @JsonProperty("subscribe")
    private boolean subscribe;

    @JsonProperty("openid")
    private String openId;

    @JsonProperty("nickname")
    private String nickname;

    @JsonProperty("sex")
    private int sex;

    @JsonProperty("language")
    private String language;

    @JsonProperty("city")
    private String city;

    @JsonProperty("province")
    private String province;

    @JsonProperty("country")
    private String country;

    @JsonProperty("headimgurl")
    private String headUrl;

    @JsonProperty("subscribe_time")
    private long subscribeTime;

    @JsonProperty("unionid")
    private String unionId;

    @JsonProperty("remark")
    private String remark;

    @JsonProperty("groupid")
    private int groupId;
}

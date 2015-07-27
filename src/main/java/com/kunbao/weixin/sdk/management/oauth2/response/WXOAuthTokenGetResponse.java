package com.kunbao.weixin.sdk.management.oauth2.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import lombok.Getter;

/**
 * Created by baylor on 15/7/25.
 */

/**
 * {
 * "access_token":"ACCESS_TOKEN",
 * "expires_in":7200,
 * "refresh_token":"REFRESH_TOKEN",
 * "openid":"OPENID",
 * "scope":"SCOPE",
 * "unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL"
 * }
 * <p/>
 * 参数	描述
 * access_token	网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
 * expires_in	access_token接口调用凭证超时时间，单位（秒）
 * refresh_token	用户刷新access_token
 * openid	用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID
 * scope	用户授权的作用域，使用逗号（,）分隔
 * unionid	只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。详见：获取用户个人信息（UnionID机制）
 * <p/>
 * refresh_token拥有较长的有效期（7天、30天、60天、90天），当refresh_token失效的后，需要用户重新授权。
 */
@Getter
public class WXOAuthTokenGetResponse extends WXJsonResponse {
    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private long expires;

    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty("openid")
    private String openId;

    @JsonProperty("unionid")
    private String unionId;

    @JsonProperty("scope")
    private String scope;
}

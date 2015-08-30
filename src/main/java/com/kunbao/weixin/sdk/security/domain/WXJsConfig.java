package com.kunbao.weixin.sdk.security.domain;

import com.kunbao.weixin.sdk.base.domain.constant.WXAppConstant;
import com.kunbao.weixin.sdk.util.UUIDUtil;
import com.kunbao.weixin.sdk.util.WXSignatureUtil;
import lombok.Getter;

import java.util.UUID;

/**
 * wx.config({
 * debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
 * appId: '', // 必填，公众号的唯一标识
 * timestamp: , // 必填，生成签名的时间戳
 * nonceStr: '', // 必填，生成签名的随机串
 * signature: '',// 必填，签名，见附录1
 * jsApiList: [] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
 * });
 * Created by lemon_bar on 15/8/30.
 */
@Getter
public class WXJsConfig {
    private String appId;
    private String timestamp;
    private String nonceStr;
    private String signature;
    private String url;
    private String jsapiTicket;

    public WXJsConfig(String url, String jsapiTicket) {
        this.appId = WXAppConstant.APP_ID;
        this.nonceStr = UUIDUtil.createUUID();
        this.timestamp = Long.toString(System.currentTimeMillis() / 1000);
        this.url = url;
        this.jsapiTicket = jsapiTicket;
        this.signature = WXSignatureUtil.genSignature(this.jsapiTicket, this.url, this.nonceStr, this.timestamp);
    }

    private String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    private String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }
}

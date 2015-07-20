package com.kunbao.weixin.sdk;

import com.kunbao.weixin.sdk.base.domain.constant.WXConstant;
import com.kunbao.weixin.sdk.message.WXMessageService;
import com.kunbao.weixin.sdk.message.domain.base.WXMessageBase;
import com.kunbao.weixin.sdk.security.WXSecurityService;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by lemon_bar on 15/7/19.
 */
@Slf4j
public class WXApi {
    public WXApi(String appId, String appSecret, String appToken, String encodingAESKey) {
        WXConstant.init(appId, appSecret, appToken, encodingAESKey);
    }

    public boolean checkSignature(String signature, String timestamp, String nonce) {
        return WXSecurityService.checkSignature(signature, timestamp, nonce);
    }

    // url上无encrypt_type参数或者其值为raw时表示为不加密；
    // encrypt_type为aes时，表示aes加密（暂时只有raw和aes两种值)。
    // 公众帐号开发者根据此参数来判断微信公众平台发送的消息是否加密。
    public String decryptContent(String encryptType, String msgSignature, String timestamp, String nonce, String content) {
        return WXSecurityService.decryptContent(encryptType, msgSignature, timestamp, nonce, content);
    }

    public String encryptContent(String encryptType, String timestamp, String nonce, String content) {
        return WXSecurityService.encryptContent(encryptType, timestamp, nonce, content);
    }

    public WXMessageBase consumeMessage(String messageStr) {
        return WXMessageService.consumeMessage(messageStr);
    }

    public String produceText(String fromUser, String toUser, String content) {
        return WXMessageService.produceText(fromUser, toUser, content);
    }

    public String produceImage(String fromUser, String toUser, String mediaId) {
        return WXMessageService.produceImage(fromUser, toUser, mediaId);
    }

}

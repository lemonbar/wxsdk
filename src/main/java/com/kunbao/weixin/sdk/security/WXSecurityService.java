package com.kunbao.weixin.sdk.security;

import com.kunbao.weixin.sdk.base.domain.constant.WXConstant;
import com.kunbao.weixin.sdk.util.WXSignatureUtil;
import com.kunbao.weixin.sdk.util.aes.AesException;
import com.kunbao.weixin.sdk.util.aes.WXBizMsgCrypt;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by lemon_bar on 15/7/19.
 */
@Slf4j
public class WXSecurityService {
    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        return WXSignatureUtil.checkSignature(signature, timestamp, nonce, WXConstant.TOKEN);
    }

    public static String decryptContent(String encryptType, String msgSignature, String timestamp, String nonce, String content) {
        WXBizMsgCrypt msgCrypt = null;
        if ("aes".equals(encryptType)) {
            try {
                msgCrypt = new WXBizMsgCrypt(WXConstant.TOKEN, WXConstant.EncodingAESKey, WXConstant.APP_ID);
                content = msgCrypt.decryptMsg(msgSignature, timestamp, nonce, content);
                log.info("decrypted weixin message is: {}", content);
            } catch (AesException e) {
                e.printStackTrace();
                log.error("decrypted weixin message error: {}", e.getMessage());
                return content;
            }
        }
        return content;
    }

    public static String encryptContent(String encryptType, String timestamp, String nonce, String content) {
        WXBizMsgCrypt msgCrypt = null;
        //加密
        if ("aes".equals(encryptType)) {
            try {
                msgCrypt = new WXBizMsgCrypt(WXConstant.TOKEN, WXConstant.EncodingAESKey, WXConstant.APP_ID);
                content = msgCrypt.encryptMsg(content, timestamp, nonce);
                log.info("encrypt wexin message is: {}", content);
            } catch (AesException e) {
                e.printStackTrace();
                log.error("encrypt weixin message error: {}", e.getMessage());
                return content;
            }
        }

        return content;
    }
}

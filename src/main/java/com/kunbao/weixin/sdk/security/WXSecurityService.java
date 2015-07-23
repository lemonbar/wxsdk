package com.kunbao.weixin.sdk.security;

import com.kunbao.weixin.sdk.base.WXHttpDispatch;
import com.kunbao.weixin.sdk.base.domain.constant.WXAppConstant;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.security.request.WXServerIplistRequest;
import com.kunbao.weixin.sdk.security.response.WXServerIpListResponse;
import com.kunbao.weixin.sdk.token.WXTokenController;
import com.kunbao.weixin.sdk.util.WXSignatureUtil;
import com.kunbao.weixin.sdk.util.aes.AesException;
import com.kunbao.weixin.sdk.util.aes.WXBizMsgCrypt;

import java.util.List;

/**
 * Created by lemon_bar on 15/7/19.
 */
public class WXSecurityService {
    public boolean checkSignature(String signature, String timestamp, String nonce) {
        return WXSignatureUtil.checkSignature(signature, timestamp, nonce, WXAppConstant.TOKEN);
    }

    public String decryptContent(String encryptType, String msgSignature, String timestamp, String nonce, String content) throws AesException {
        WXBizMsgCrypt msgCrypt = null;
        if ("aes".equals(encryptType)) {
            try {
                msgCrypt = new WXBizMsgCrypt(WXAppConstant.TOKEN, WXAppConstant.EncodingAESKey, WXAppConstant.APP_ID);
                content = msgCrypt.decryptMsg(msgSignature, timestamp, nonce, content);
            } catch (AesException e) {
                e.printStackTrace();
                throw e;
            }
        }
        return content;
    }

    public String encryptContent(String encryptType, String timestamp, String nonce, String content) throws AesException {
        WXBizMsgCrypt msgCrypt = null;
        //加密
        if ("aes".equals(encryptType)) {
            try {
                msgCrypt = new WXBizMsgCrypt(WXAppConstant.TOKEN, WXAppConstant.EncodingAESKey, WXAppConstant.APP_ID);
                content = msgCrypt.encryptMsg(content, timestamp, nonce);
            } catch (AesException e) {
                e.printStackTrace();
                throw e;
            }
        }

        return content;
    }

    public List<String> getCallbackIpList() throws WXException {
        WXServerIplistRequest request = new WXServerIplistRequest(WXTokenController.getToken());
        WXServerIpListResponse response = (WXServerIpListResponse) WXHttpDispatch.execute(request);
        return response.getIpList();
    }
}

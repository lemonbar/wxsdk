package com.kunbao.weixin.sdk;

import com.kunbao.weixin.sdk.base.domain.constant.WXAppInfo;
import com.kunbao.weixin.sdk.management.menu.domain.Menu;
import com.kunbao.weixin.sdk.management.menu.response.WXMenuGetResponse;
import com.kunbao.weixin.sdk.management.menu.response.WXSelfMenuGetResponse;
import com.kunbao.weixin.sdk.management.user.response.WXUserGetResponse;
import com.kunbao.weixin.sdk.management.user.response.WXUserInfoResponse;
import com.kunbao.weixin.sdk.message.domain.base.WXMessageBase;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by lemon_bar on 15/7/19.
 */
@Slf4j
public class WXApi {
    private WXServiceFactory factory;

    public WXApi(String appId, String appSecret, String appToken, String encodingAESKey) {
        WXAppInfo.init(appId, appSecret, appToken, encodingAESKey);
        factory = new WXServiceFactory();
    }

    public boolean checkSignature(String signature, String timestamp, String nonce) {
        return factory.getWxSecurityService().checkSignature(signature, timestamp, nonce);
    }

    // url上无encrypt_type参数或者其值为raw时表示为不加密；
    // encrypt_type为aes时，表示aes加密（暂时只有raw和aes两种值)。
    // 公众帐号开发者根据此参数来判断微信公众平台发送的消息是否加密。
    public String decryptContent(String encryptType, String msgSignature, String timestamp, String nonce, String content) {
        return factory.getWxSecurityService().decryptContent(encryptType, msgSignature, timestamp, nonce, content);
    }

    public String encryptContent(String encryptType, String timestamp, String nonce, String content) {
        return factory.getWxSecurityService().encryptContent(encryptType, timestamp, nonce, content);
    }

    public WXMessageBase consumeMessage(String messageStr) {
        return factory.getWxMessageService().consumeMessage(messageStr);
    }

    public String produceText(String fromUser, String toUser, String content) {
        return factory.getWxMessageService().produceText(fromUser, toUser, content);
    }

    public String produceImage(String fromUser, String toUser, String mediaId) {
        return factory.getWxMessageService().produceImage(fromUser, toUser, mediaId);
    }

    //the method about account.
    public String long2ShortUrl(String longUrl) {
        return factory.getWxAccountService().long2ShortUrl(longUrl);
    }

    public String createTempQrcode(long expireSeconds, int scenceId) {
        return factory.getWxAccountService().createTempQrcode(expireSeconds, scenceId);
    }

    public String createLimitSceneQrCode(int scenceId) {
        return factory.getWxAccountService().createLimitSceneQrCode(scenceId);
    }

    public String createLimitStrSceneQrCode(String scenceStr) {
        return factory.getWxAccountService().createLimitStrSceneQrCode(scenceStr);
    }

    public boolean createMenu(Menu menu) {
        return factory.getWxMenuService().createMenu(menu);
    }

    public WXMenuGetResponse getMenu() {
        return factory.getWxMenuService().getMenu();
    }

    public WXSelfMenuGetResponse getSelfMenu() {
        return factory.getWxMenuService().getSelfMenu();
    }

    public boolean deleteMenu() {
        return factory.getWxMenuService().deleteMenu();
    }

    public WXUserGetResponse getUserList(String nextOpenId) {
        return factory.getWxUserService().getUserList(nextOpenId);
    }

    public WXUserInfoResponse getUserInfo(String openId, String lang) {
        return factory.getWxUserService().getUserInfo(openId, lang);
    }

}

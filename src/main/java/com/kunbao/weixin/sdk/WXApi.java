package com.kunbao.weixin.sdk;

import com.kunbao.weixin.sdk.base.domain.constant.WXAppConstant;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.message.domain.base.WXMessageBase;
import com.kunbao.weixin.sdk.message.domain.send.json.metadata.MusicContent;
import com.kunbao.weixin.sdk.message.domain.send.json.metadata.NewsItemContent;
import com.kunbao.weixin.sdk.message.domain.send.json.metadata.VideoContent;
import com.kunbao.weixin.sdk.message.domain.send.xml.WXSendMusicMedia;
import com.kunbao.weixin.sdk.message.domain.send.xml.WXSendNewsItem;
import com.kunbao.weixin.sdk.message.domain.send.xml.WXSendVideoMedia;
import com.kunbao.weixin.sdk.util.aes.AesException;

import java.util.List;

/**
 * Created by lemon_bar on 15/7/19.
 */
public class WXApi {
    private WXServiceFactory factory;

    /**
     * 微信api接口
     *
     * @param appId          app id
     * @param appSecret      app secret
     * @param appToken       app token
     * @param encodingAESKey encoding aes key
     */
    public WXApi(String appId, String appSecret, String appToken, String encodingAESKey) {
        WXAppConstant.init(appId, appSecret, appToken, encodingAESKey);
        factory = new WXServiceFactory();
    }

    /**
     * 通过检验signature对请求进行校验
     *
     * @param signature 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     * @param timestamp 时间戳
     * @param nonce     随机数
     * @return 若返回true，请原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败。
     */
    public boolean checkSignature(String signature, String timestamp, String nonce) {
        return factory.getWxSecurityService().checkSignature(signature, timestamp, nonce);
    }

    /**
     * 解密消息
     *
     * @param encryptType  加密类型，encrypt_type为aes时，表示aes加密（暂时只有raw和aes两种值)。
     * @param msgSignature 表示对消息体的签名
     * @param timestamp    时间戳
     * @param nonce        随机数
     * @param content      需要解密的消息
     * @return 解密后的消息
     * @throws AesException
     */
    public String decryptContent(String encryptType, String msgSignature, String timestamp, String nonce, String content) throws AesException {
        return factory.getWxSecurityService().decryptContent(encryptType, msgSignature, timestamp, nonce, content);
    }

    /**
     * 加密消息
     *
     * @param encryptType 加密类型，encrypt_type为aes时，表示aes加密（暂时只有raw和aes两种值)。
     * @param timestamp   时间戳
     * @param nonce       随机数
     * @param content     需要加密的消息
     * @return 加密后的消息
     * @throws AesException
     */
    public String encryptContent(String encryptType, String timestamp, String nonce, String content) throws AesException {
        return factory.getWxSecurityService().encryptContent(encryptType, timestamp, nonce, content);
    }

    /**
     * 获得微信服务器IP地址列表
     *
     * @return 微信服务器IP地址列表
     */
    public List<String> getCallbackIpList() throws WXException {
        return factory.getWxSecurityService().getCallbackIpList();
    }

    /**
     * 解析从微信推送过来的消息
     *
     * @param messageStr
     * @return 解析出来的消息类实例
     * @throws WXException
     */
    public WXMessageBase consumeMessage(String messageStr) throws WXException {
        return factory.getWxMessageService().consumeMessage(messageStr);
    }

    /**
     * 产生需要被动回复的文本消息
     *
     * @param fromUser 公众号id
     * @param toUser   用户的open_id
     * @param content  回复的文本内容
     * @return xml内容
     * @throws WXException
     */
    public String produceText(String fromUser, String toUser, String content) throws WXException {
        return factory.getWxMessageService().produceText(fromUser, toUser, content);
    }

    /**
     * 产生需要被动回复的图片消息
     *
     * @param fromUser 公众号id
     * @param toUser   用户的open_id
     * @param mediaId  图片的id
     * @return xml内容
     * @throws WXException
     */
    public String produceImage(String fromUser, String toUser, String mediaId) throws WXException {
        return factory.getWxMessageService().produceImage(fromUser, toUser, mediaId);
    }

    /**
     * 产生需要被动回复的音频消息
     *
     * @param fromUser 公众号id
     * @param toUser   用户的open_id
     * @param mediaId  音频的id
     * @return xml内容
     * @throws WXException
     */
    public String produceVoice(String fromUser, String toUser, String mediaId) throws WXException {
        return factory.getWxMessageService().produceVoice(fromUser, toUser, mediaId);
    }

    /**
     * 产生需要被动回复的视频消息
     *
     * @param fromUser   公众号id
     * @param toUser     用户的open_id
     * @param videoMedia 视频的id
     * @return xml内容
     * @throws WXException
     */
    public String produceVideo(String fromUser, String toUser, WXSendVideoMedia videoMedia) throws WXException {
        return factory.getWxMessageService().produceVideo(fromUser, toUser, videoMedia);
    }

    /**
     * 产生需要被动回复的音乐消息
     *
     * @param fromUser   公众号id
     * @param toUser     用户的open_id
     * @param musicMedia 音乐资源
     * @return 音乐xml内容
     * @throws WXException
     */
    public String produceMusic(String fromUser, String toUser, WXSendMusicMedia musicMedia) throws WXException {
        return factory.getWxMessageService().produceMusic(fromUser, toUser, musicMedia);
    }

    /**
     * 产生需要被动回复的图文消息
     *
     * @param fromUser  公众号id
     * @param toUser    用户的open_id
     * @param newsItems 图文资源(图文消息个数，限制为10条以内)
     * @return 图文xml内容
     * @throws WXException
     */
    public String produceNews(String fromUser, String toUser, List<WXSendNewsItem> newsItems) throws WXException {
        return factory.getWxMessageService().produceNews(fromUser, toUser, newsItems);
    }

    /**
     * 发送文本内容的客服消息
     *
     * @param toUser  用户的open_id
     * @param content 文本内容
     * @return 是否发送成功
     * @throws WXException
     */
    public boolean sendCustomText(String toUser, String content) throws WXException {
        return factory.getWxMessageService().sendCustomText(toUser, content);
    }

    /**
     * 发送图片的客服消息
     *
     * @param toUser  用户的open_id
     * @param mediaId 图片media id
     * @return 是否发送成功
     * @throws WXException
     */
    public boolean sendCustomImage(String toUser, String mediaId) throws WXException {
        return factory.getWxMessageService().sendCustomImage(toUser, mediaId);
    }

    /**
     * 发送音频的客服消息
     *
     * @param toUser  用户的open_id
     * @param mediaId 音频media id
     * @return 是否发送成功
     * @throws WXException
     */
    public boolean sendCustomVoice(String toUser, String mediaId) throws WXException {
        return factory.getWxMessageService().sendCustomVoice(toUser, mediaId);
    }

    /**
     * 发送视频的客服消息
     *
     * @param toUser       用户的open_id
     * @param videoContent 视频信息
     * @return 是否发送成功
     * @throws WXException
     */
    public boolean sendCustomVideo(String toUser, VideoContent videoContent) throws WXException {
        return factory.getWxMessageService().sendCustomVideo(toUser, videoContent);
    }

    /**
     * 发送音乐的客服消息
     *
     * @param toUser       用户的open_id
     * @param musicContent 音乐信息
     * @return 是否发送成功
     * @throws WXException
     */
    public boolean sendCustomMusic(String toUser, MusicContent musicContent) throws WXException {
        return factory.getWxMessageService().sendCustomMusic(toUser, musicContent);
    }

    /**
     * 发送图文的客服消息
     *
     * @param toUser      用户的open_id
     * @param newsContent 图文信息
     * @return 是否发送成功
     * @throws WXException
     */
    public boolean sendCustomNews(String toUser, List<NewsItemContent> newsContent) throws WXException {
        return factory.getWxMessageService().sendCustomNews(toUser, newsContent);
    }

//    //the method about account.
//    public String long2ShortUrl(String longUrl) {
//        return factory.getWxAccountService().long2ShortUrl(longUrl);
//    }
//
//    public String createTempQrcode(long expireSeconds, int scenceId) {
//        return factory.getWxAccountService().createTempQrcode(expireSeconds, scenceId);
//    }
//
//    public String createLimitSceneQrCode(int scenceId) {
//        return factory.getWxAccountService().createLimitSceneQrCode(scenceId);
//    }
//
//    public String createLimitStrSceneQrCode(String scenceStr) {
//        return factory.getWxAccountService().createLimitStrSceneQrCode(scenceStr);
//    }
//
//    public boolean createMenu(Menu menu) {
//        return factory.getWxMenuService().createMenu(menu);
//    }
//
//    public WXMenuGetResponse getMenu() {
//        return factory.getWxMenuService().getMenu();
//    }
//
//    public WXSelfMenuGetResponse getSelfMenu() {
//        return factory.getWxMenuService().getSelfMenu();
//    }
//
//    public boolean deleteMenu() {
//        return factory.getWxMenuService().deleteMenu();
//    }
//
//    public WXUserGetResponse getUserList(String nextOpenId) {
//        return factory.getWxUserService().getUserList(nextOpenId);
//    }
//
//    public WXUserInfoResponse getUserInfo(String openId, String lang) {
//        return factory.getWxUserService().getUserInfo(openId, lang);
//    }

}

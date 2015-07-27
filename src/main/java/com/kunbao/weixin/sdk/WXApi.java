package com.kunbao.weixin.sdk;

import com.kunbao.weixin.sdk.base.domain.constant.WXAppConstant;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.datacube.user.domain.UserSummaryItem;
import com.kunbao.weixin.sdk.management.material.domain.MaterialPageableRequest;
import com.kunbao.weixin.sdk.management.material.domain.NewsList;
import com.kunbao.weixin.sdk.management.material.domain.NewsUpdater;
import com.kunbao.weixin.sdk.management.material.domain.constant.MediaType;
import com.kunbao.weixin.sdk.management.material.response.WXAddCommonMaterialResponse;
import com.kunbao.weixin.sdk.management.material.response.WXGetCommonMaterialListResponse;
import com.kunbao.weixin.sdk.management.material.response.WXGetMaterialCountResponse;
import com.kunbao.weixin.sdk.management.material.response.WXGetNewsMaterialListResponse;
import com.kunbao.weixin.sdk.management.menu.domain.Menu;
import com.kunbao.weixin.sdk.management.menu.response.WXMenuGetResponse;
import com.kunbao.weixin.sdk.management.menu.response.WXSelfMenuGetResponse;
import com.kunbao.weixin.sdk.management.oauth2.response.WXOAuthTokenGetResponse;
import com.kunbao.weixin.sdk.management.oauth2.response.WXOAuthUserInfoGetResponse;
import com.kunbao.weixin.sdk.management.user.domain.WXLang;
import com.kunbao.weixin.sdk.management.user.domain.WXUserGroup;
import com.kunbao.weixin.sdk.management.user.domain.WXUserList;
import com.kunbao.weixin.sdk.management.user.response.WXUserGetResponse;
import com.kunbao.weixin.sdk.management.user.response.WXUserInfoListResponse;
import com.kunbao.weixin.sdk.management.user.response.WXUserInfoResponse;
import com.kunbao.weixin.sdk.message.domain.base.WXMessageBase;
import com.kunbao.weixin.sdk.message.domain.send.json.metadata.MusicContent;
import com.kunbao.weixin.sdk.message.domain.send.json.metadata.NewsItemContent;
import com.kunbao.weixin.sdk.message.domain.send.json.metadata.VideoContent;
import com.kunbao.weixin.sdk.message.domain.send.xml.WXSendMusicMedia;
import com.kunbao.weixin.sdk.message.domain.send.xml.WXSendNewsItem;
import com.kunbao.weixin.sdk.message.domain.send.xml.WXSendVideoMedia;
import com.kunbao.weixin.sdk.util.aes.AesException;

import java.util.Date;
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
     * @param callbackUrl    app callback url
     */
    public WXApi(String appId, String appSecret, String appToken, String encodingAESKey, String callbackUrl) {
        WXAppConstant.init(appId, appSecret, appToken, encodingAESKey, callbackUrl);
        factory = new WXServiceFactory();
    }

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

    /**
     * 新增临时素材
     *
     * @param type     素材类型
     * @param filePath 素材路径
     * @return 新增后，素材的链接
     * @throws WXException
     */
    public String uploadTempMedia(MediaType type, String filePath) throws WXException {
        return factory.getWxMaterialService().uploadTempMedia(type, filePath);
    }

    /**
     * 新增图文永久素材
     *
     * @param newsList 图文列表
     * @return media Id
     * @throws WXException
     */
    public String addNewsList(NewsList newsList) throws WXException {
        return factory.getWxMaterialService().addNewsList(newsList);
    }

    /**
     * 新增其它类型永久素材
     *
     * @param filePath 素材路径
     * @return 素材media id 和 url
     * @throws WXException
     */
    public WXAddCommonMaterialResponse addCommonMaterial(String filePath) throws WXException {
        return factory.getWxMaterialService().addCommonMaterial(filePath);
    }

    /**
     * 删除永久素材
     *
     * @param mediaId media id
     * @return true代表成功
     * @throws WXException
     */
    public boolean deleteMaterial(String mediaId) throws WXException {
        return factory.getWxMaterialService().deleteMaterial(mediaId);
    }

    /**
     * 更新永久图文素材
     *
     * @param newsUpdater 需要更新的内容
     * @return true代表成功
     * @throws WXException
     */
    public boolean updateNewsItem(NewsUpdater newsUpdater) throws WXException {
        return factory.getWxMaterialService().updateNewsItem(newsUpdater);
    }

    /**
     * 获取素材总数
     *
     * @return 素材总数
     * @throws WXException
     */
    public WXGetMaterialCountResponse getMaterialCount() throws WXException {
        return factory.getWxMaterialService().getCount();
    }

    /**
     * 获取普通素材列表
     *
     * @param pageableRequest 查询条件
     * @return 普通素材列表
     * @throws WXException
     */
    public WXGetCommonMaterialListResponse getCommonMaterialList(MaterialPageableRequest pageableRequest) throws WXException {
        return factory.getWxMaterialService().getCommonMaterialList(pageableRequest);
    }

    /**
     * 获取图文素材列表
     *
     * @param pageableRequest 查询条件
     * @return 图文素材列表
     * @throws WXException
     */
    public WXGetNewsMaterialListResponse getNewsMaterialList(MaterialPageableRequest pageableRequest) throws WXException {
        return factory.getWxMaterialService().getNewsMaterialList(pageableRequest);
    }

    /**
     * 创建用户分组
     *
     * @param groupName 分组名称
     * @return 新建分组信息
     * @throws WXException
     */
    public WXUserGroup createUserGroup(String groupName) throws WXException {
        return factory.getWxUserService().createUserGroup(groupName);
    }

    /**
     * 获取分组列表
     *
     * @return 分组列表
     * @throws WXException
     */
    public List<WXUserGroup> getUserGroup() throws WXException {
        return factory.getWxUserService().getUserGroup();
    }

    /**
     * 获取用户所在分组id
     *
     * @param openId 用户openid
     * @return 用户所在分组id
     * @throws WXException
     */
    public int getUserInGroupId(String openId) throws WXException {
        return factory.getWxUserService().getUserInGroupId(openId);
    }

    /**
     * 更新分组名称
     *
     * @param groupId   分组id
     * @param groupName 分组名称
     * @return 是否成功
     * @throws WXException
     */
    public boolean updateUserGroup(int groupId, String groupName) throws WXException {
        return factory.getWxUserService().updateUserGroup(groupId, groupName);
    }

    /**
     * 移动用户到某个分组
     *
     * @param openId  用户openid
     * @param groupId 分组id
     * @return 是否成功
     * @throws WXException
     */
    public boolean moveUserToGroup(String openId, int groupId) throws WXException {
        return factory.getWxUserService().moveUserToGroup(openId, groupId);
    }

    /**
     * 批量移动用户
     *
     * @param openIdList 用户openid列表
     * @param groupId    分组id
     * @return 是否成功
     * @throws WXException
     */
    public boolean moveBatchUserToGroup(List<String> openIdList, int groupId) throws WXException {
        return factory.getWxUserService().moveBatchUserToGroup(openIdList, groupId);
    }

    /**
     * 删除用户分组
     *
     * @param groupId 分组id
     * @return 是否成功
     * @throws WXException
     */
    public boolean deleteUseGroup(int groupId) throws WXException {
        return factory.getWxUserService().deleteUseGroup(groupId);
    }

    /**
     * 设置用户备注名
     *
     * @param openId 用户openid
     * @param remark 备注名
     * @return 是否成功
     * @throws WXException
     */
    public boolean remarkUser(String openId, String remark) throws WXException {
        return factory.getWxUserService().remarkUser(openId, remark);
    }

    /**
     * 获取用户列表
     *
     * @param nextOpenId 起始的openid
     * @return 用户列表
     * @throws WXException
     */
    public WXUserGetResponse getUserList(String nextOpenId) throws WXException {
        return factory.getWxUserService().getUserList(nextOpenId);
    }

    /**
     * 获取用户信息
     *
     * @param openId 用户openid
     * @param lang   语言
     * @return 用户信息
     * @throws WXException
     */
    public WXUserInfoResponse getUserInfo(String openId, WXLang lang) throws WXException {
        return factory.getWxUserService().getUserInfo(openId, lang);
    }

    /**
     * 批量获取用户信息
     *
     * @param userList 用户openid列表
     * @return 用户信息
     * @throws WXException
     */
    public WXUserInfoListResponse getBatchUserInfo(WXUserList userList) throws WXException {
        return factory.getWxUserService().getBatchUserInfo(userList);
    }

    /**
     * 创建菜单
     *
     * @param menu 菜单
     * @return 是否成功
     * @throws WXException
     */
    public boolean createMenu(Menu menu) throws WXException {
        return factory.getWxMenuService().createMenu(menu);
    }

    /**
     * 获取菜单
     *
     * @return 菜单
     * @throws WXException
     */
    public WXMenuGetResponse getMenu() throws WXException {
        return factory.getWxMenuService().getMenu();
    }

    /**
     * 获取自定义菜单配置
     *
     * @return 自定义菜单配置
     * @throws WXException
     */
    public WXSelfMenuGetResponse getSelfMenu() throws WXException {
        return factory.getWxMenuService().getSelfMenu();
    }

    /**
     * 删除菜单
     *
     * @return 是否成功
     * @throws WXException
     */
    public boolean deleteMenu() throws WXException {
        return factory.getWxMenuService().deleteMenu();
    }

    /**
     * 把长链接转为短链接
     *
     * @param longUrl 长链接
     * @return 短链接
     * @throws WXException
     */
    public String long2ShortUrl(String longUrl) throws WXException {
        return factory.getWxAccountService().long2ShortUrl(longUrl);
    }

    /**
     * 创建临时二维码
     *
     * @param expireSeconds 过期时间，单位秒，最大不超过604800（7天）
     * @param scenceId      场景id
     * @return 二维码链接
     * @throws WXException
     */
    public String createTempQrcode(long expireSeconds, int scenceId) throws WXException {
        return factory.getWxAccountService().createTempQrcode(expireSeconds, scenceId);
    }

    /**
     * 创建带有场景id的永久二维码
     *
     * @param scenceId 场景id
     * @return 二维码链接
     * @throws WXException
     */
    public String createLimitSceneQrCode(int scenceId) throws WXException {
        return factory.getWxAccountService().createLimitSceneQrCode(scenceId);
    }

    /**
     * 创建带有场景string的永久二维码
     *
     * @param scenceStr 场景的string值
     * @return 二维码链接
     * @throws WXException
     */
    public String createLimitStrSceneQrCode(String scenceStr) throws WXException {
        return factory.getWxAccountService().createLimitStrSceneQrCode(scenceStr);
    }

    /**
     * 通过用户授权获取的auth code 拉取auth token
     *
     * @param authCode 微信回调获取的auth code
     * @return
     * @throws WXException
     */
    public WXOAuthTokenGetResponse getAuthToken(String authCode) throws WXException {
        return factory.getWxOAuthService().getOAuthAccessToken(authCode);
    }

    public WXOAuthUserInfoGetResponse getAuthUserInfo(String authCode, String lang) throws WXException {
        return factory.getWxOAuthService().getAuthUserInfo(authCode, lang);
    }

    public WXOAuthUserInfoGetResponse getAuthUserInfo(String accessToken, String openId, String lang) throws WXException {
        return factory.getWxOAuthService().getAuthUserInfo(accessToken, openId, lang);
    }

    /**
     * 获取用户增减数据,最大时间跨度7天。
     *
     * @param start 开始日期
     * @param end   结束日期
     * @return 数据列表
     * @throws WXException
     */
    public List<UserSummaryItem> getUserSummaryDataCube(Date start, Date end) throws WXException {
        return factory.getUserDataCubeService().getUserSummary(start, end);
    }
}

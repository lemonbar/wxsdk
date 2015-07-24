微信服务号 SDK for Java
=====

###如何使用？

在maven工程的pom.xml，添加下面的引用。

`<dependency>`<br/>
&nbsp;&nbsp;&nbsp;&nbsp;`<groupId>com.kunbao.weixin</groupId>`<br/>
&nbsp;&nbsp;&nbsp;&nbsp;`<artifactId>sdk</artifactId>`<br/>
&nbsp;&nbsp;&nbsp;&nbsp;`<version>1.0</version>`<br/>
`</dependency>`<br/>

====
###初始化

推荐使用下面的单例模式进行初始化。

`private WXApi wxApi;`<br/>
`public synchronized WXApi getWxApi() {`<br/>
&nbsp;&nbsp;&nbsp;&nbsp;`if (wxApi == null) {`<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`wxApi = new WXApi(WXConstant.APP_ID, WXConstant.APP_SECRET, WXConstant.TOKEN, WXConstant.EncodingAESKey);`<br/>
&nbsp;&nbsp;&nbsp;&nbsp;`}`<br/>
&nbsp;&nbsp;&nbsp;&nbsp;`return wxApi;`<br/>
`}`<br/>

====
###接口介绍

所有的方法都通过wxApi进行调用，简单易用。<br/>
开发者不需要关心token，相关的刷新逻辑已经封装在代码中。

#####安全相关的接口
1. 验证服务器地址有效性<br/>
`boolean checkSignature(String signature, String timestamp, String nonce)`<br/>

2. 解密消息<br/>
`String decryptContent(String encryptType, String msgSignature, String timestamp, String nonce, String content) throws AesException`<br/>

3. 加密消息<br/>
`String encryptContent(String encryptType, String timestamp, String nonce, String content) throws AesException`<br/>

4. 获得微信服务器IP地址列表<br/>
`List<String> getCallbackIpList() throws WXException`<br/>

#####消息相关的接口
1. 解析接受的消息<br/>
`WXMessageBase consumeMessage(String messageStr) throws WXException`<br/>

2. 产生被动回复消息<br/>
`String produceText(String fromUser, String toUser, String content) throws WXException`<br/>
`String produceImage(String fromUser, String toUser, String mediaId) throws WXException`<br/>
`String produceVoice(String fromUser, String toUser, String mediaId) throws WXException`<br/>
`String produceVideo(String fromUser, String toUser, WXSendVideoMedia videoMedia) throws WXException`<br/>
`String produceMusic(String fromUser, String toUser, WXSendMusicMedia musicMedia) throws WXException`<br/>
`String produceNews(String fromUser, String toUser, List<WXSendNewsItem> newsItems) throws WXException`<br/>

3. 发送客服消息<br/>
`boolean sendCustomText(String toUser, String content) throws WXException`<br/>
`boolean sendCustomImage(String toUser, String mediaId) throws WXException`<br/>
`boolean sendCustomVoice(String toUser, String mediaId) throws WXException`<br/>
`boolean sendCustomVideo(String toUser, VideoContent videoContent) throws WXException`<br/>
`boolean sendCustomMusic(String toUser, MusicContent musicContent) throws WXException`<br/>
`boolean sendCustomNews(String toUser, List<NewsItemContent> articles) throws WXException`<br/>

#####素材管理接口<br/>
1. 新增临时素材，返回新增素材的url<br/>
`String uploadTempMedia(MediaType type, String filePath) throws WXException`<br/>

2. 新增永久图文素材<br/>
`String addNewsList(NewsList newsList) throws WXException`<br/>

3. 新增永久其它素材<br/>
`WXAddCommonMaterialResponse addCommonMaterial(String filePath) throws WXException`<br/>

4. 删除永久素材<br/>
`boolean deleteMaterial(String mediaId) throws WXException`<br/>

5. 修改永久图文素材<br/>
`boolean updateNewsItem(NewsUpdater newsUpdater) throws WXException`<br/>

6. 获取素材总数<br/>
`WXGetMaterialCountResponse getMaterialCount() throws WXException`<br/>

7. 获取素材列表<br/>
`WXGetCommonMaterialListResponse getCommonMaterialList(MaterialPageableRequest pageableRequest) throws WXException`<br/>
`WXGetNewsMaterialListResponse getNewsMaterialList(MaterialPageableRequest pageableRequest) throws WXException`<br/>

#####用户管理接口<br/>
1. 用户分组管理<br/>
`WXUserGroup createUserGroup(String groupName) throws WXException`<br/>
`List<WXUserGroup> getUserGroup() throws WXException`<br/>
`int getUserInGroupId(String openId) throws WXException`<br/>
`boolean updateUserGroup(int groupId, String groupName) throws WXException`<br/>
`boolean moveUserToGroup(String openId, int groupId) throws WXException`<br/>
`boolean moveBatchUserToGroup(List<String> openIdList, int groupId) throws WXException`<br/>
`boolean deleteUseGroup(int groupId) throws WXException`<br/>

2. 设置用户备注名<br/>
`boolean remarkUser(String openId, String remark) throws WXException`<br/>

3. 获取用户基本信息<br/>
`WXUserInfoResponse getUserInfo(String openId, WXLang lang) throws WXException`<br/>
`WXUserInfoListResponse getBatchUserInfo(WXUserList userList) throws WXException`<br/>

4. 获取用户列表<br/>
`WXUserGetResponse getUserList(String nextOpenId) throws WXException`<br/>

#####自定义菜单接口<br/>
1. 自定义菜单创建接口<br/>
`boolean createMenu(Menu menu) throws WXException`<br/>

2. 自定义菜单查询接口<br/>
`WXMenuGetResponse getMenu() throws WXException`<br/>

3. 自定义菜单删除接口<br/>
`boolean deleteMenu() throws WXException`<br/>

4. 获取自定义菜单配置接口<br/>
`WXSelfMenuGetResponse getSelfMenu() throws WXException`<br/>

#####账号管理接口<br/>
1. 生成带参数的二维码<br/>
`String createTempQrcode(long expireSeconds, int scenceId) throws WXException`<br/>
`String createLimitSceneQrCode(int scenceId) throws WXException`<br/>
`String createLimitStrSceneQrCode(String scenceStr) throws WXException`<br/>

2. 长链接转短链接<br/>
`String long2ShortUrl(String longUrl) throws WXException`<br/>

#####未实现的接口
1. 客服账号管理<br/>
2. 群发接口<br/>
3. 模板消息接口<br/>
4. 获取自动回复规则接口<br/>
5. 数据统计接口<br/>

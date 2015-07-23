微信服务号 SDK for Java
=====

####如何使用？
在maven工程的pom.xml，添加下面的引用。

`<dependency>`<br/>
&nbsp;&nbsp;&nbsp;&nbsp;`<groupId>com.kunbao.weixin</groupId>`<br/>
&nbsp;&nbsp;&nbsp;&nbsp;`<artifactId>sdk</artifactId>`<br/>
&nbsp;&nbsp;&nbsp;&nbsp;`<version>1.0</version>`<br/>
`</dependency>`<br/>

####初始化

推荐使用下面的单例模式进行初始化。

`private WXApi wxApi;`<br/>
`public synchronized WXApi getWxApi() {`<br/>
&nbsp;&nbsp;&nbsp;&nbsp;`if (wxApi == null) {`<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`wxApi = new WXApi(WXConstant.APP_ID, WXConstant.APP_SECRET, WXConstant.TOKEN, WXConstant.EncodingAESKey);`<br/>
&nbsp;&nbsp;&nbsp;&nbsp;`}`<br/>
&nbsp;&nbsp;&nbsp;&nbsp;`return wxApi;`<br/>
`}`<br/>

####接口介绍


Change long url to short url

`String long2ShortUrl(String longUrl)`

Create temp qr code.

`String createTempQrcode(long expireSeconds, int scenceId)`

Create qr code use scence id.

`String createLimitSceneQrCode(int scenceId)`

Create qr code use scence string.

`String createLimitStrSceneQrCode(String scenceStr)`

####WX Material Service method
Get material count.

`WXGetMaterialCountResponse getCount()`

Get common material list, such as image, voice.

`WXGetCommonMaterialListResponse getCommonMaterialList(MaterialPageableRequest pageableRequest)`

Get news material list.

`WXGetNewsMaterialListResponse getNewsMaterialList(MaterialPageableRequest pageableRequest)`

Upload temp material.

`String uploadTempMedia(MediaType type, String filePath)`

####WX Menu Service method
create weixin menu

`boolean createMenu(Menu menu)`

get weixin menu

`WXMenuGetResponse getMenu()`

get weixin self menu

`WXSelfMenuGetResponse getSelfMenu()`

delete weixin menu

`boolean deleteMenu()`

####WX Message Service method
consume weixin pushed message.

`WXMessageBase consumeMessage(String messageStr)`

product reply message for weixin pushed message.

`String produceText(String fromUser, String toUser, String content)`

`String produceImage(String fromUser, String toUser, String mediaId)`

####WX User management service method
get user list.

`WXUserGetResponse getUserList(String nextOpenId)`

get user info.

`WXUserInfoResponse getUserInfo(String openId, String lang)`


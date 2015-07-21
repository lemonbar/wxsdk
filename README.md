Wei Xin SDK
=====

Please use the following method to initial your weixin configuration.

`private WXApi wxApi;`<br/>
`private synchronized WXApi getWxApi() {`<br/>
&nbsp;&nbsp;&nbsp;&nbsp;`if (wxApi == null) {`<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`wxApi = new WXApi(WXConstant.APP_ID, WXConstant.APP_SECRET, WXConstant.TOKEN, WXConstant.EncodingAESKey);`<br/>
&nbsp;&nbsp;&nbsp;&nbsp;`}`<br/>
&nbsp;&nbsp;&nbsp;&nbsp;`return wxApi;`<br/>
`}`<br/>

####WX Account Service method
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


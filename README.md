Wei Xin SDK
=====

Please invoke the following method to initial your weixin configuration.

`WXConstant.init(String appId, String appSecret, String appToken, String encodingAESKey)`

####WXAccountService
Change long url to short url

`String long2ShortUrl(String longUrl)`

Create temp qr code.

`String createTempQrcode(long expireSeconds, int scenceId)`

Create qr code use scence id.

`String createLimitSceneQrCode(int scenceId)`

Create qr code use scence string.

`String createLimitStrSceneQrCode(String scenceStr)`

####WXMaterialService
Get material count.

`WXGetMaterialCountResponse getCount()`

Get common material list, such as image, voice.

`WXGetCommonMaterialListResponse getCommonMaterialList(MaterialPageableRequest pageableRequest)`

Get news material list.

`WXGetNewsMaterialListResponse getNewsMaterialList(MaterialPageableRequest pageableRequest)`

Upload temp material.

`String uploadTempMedia(MediaType type, String filePath)`

####WXMenuService
create weixin menu

`boolean createMenu(Menu menu)`

get weixin menu

`WXMenuGetResponse getMenu()`

get weixin self menu

`WXSelfMenuGetResponse getSelfMenu()`

delete weixin menu

`boolean deleteMenu()`

####WXMessageService
consume weixin pushed message.

`WXMessageBase consumeMessage(String messageStr)`

product reply message for weixin pushed message.

`String produceText(String fromUser, String toUser, String content)`

`String produceImage(String fromUser, String toUser, String mediaId)`

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
`boolean checkSignature(String signature, String timestamp, String nonce)`
2. 解密消息<br/>
`String decryptContent(String encryptType, String msgSignature, String timestamp, String nonce, String content) throws AesException`
3. 加密消息<br/>
`String encryptContent(String encryptType, String timestamp, String nonce, String content) throws AesException`
4. 解析消息<br/>
`WXMessageBase consumeMessage(String messageStr) throws WXException`
5. 产生被动回复消息<br/>
`String produceText(String fromUser, String toUser, String content) throws WXException`<br/>
`String produceImage(String fromUser, String toUser, String mediaId) throws WXException`<br/>

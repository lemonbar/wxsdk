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

#####安全相关的接口
1. 


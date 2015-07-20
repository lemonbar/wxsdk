package com.kunbao.weixin.sdk.util;

import junit.framework.TestCase;

public class WXParserUtilTest extends TestCase {

    public void testParserPushedMessageType() throws Exception {
        String str = " <xml>\n" +
                " <ToUserName><![CDATA[OpenId]]></ToUserName>\n" +
                " <FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
                " <CreateTime>1348831860</CreateTime>\n" +
                " <MsgType><![CDATA[text]]></MsgType>\n" +
                " <Content><![CDATA[this is a url]]></Content>\n" +
                " <MsgId>1234567890123456</MsgId>\n" +
                " </xml>";
        WXParserUtil.parserPushedMessageType(str);
    }
}
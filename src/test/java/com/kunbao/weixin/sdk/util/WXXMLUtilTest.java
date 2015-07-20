package com.kunbao.weixin.sdk.util;

import com.kunbao.weixin.sdk.message.domain.base.WXMessageBase;
import com.kunbao.weixin.sdk.util.xml.WXXMLUtil;
import junit.framework.TestCase;

public class WXXMLUtilTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();

    }

    public void tearDown() throws Exception {

    }

    public void testXmlToBean() throws Exception {
        String str = " <xml>\n" +
                " <ToUserName><![CDATA[OpenId]]></ToUserName>\n" +
                " <FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
                " <CreateTime>1348831860</CreateTime>\n" +
                " <MsgType><![CDATA[image]]></MsgType>\n" +
                " <PicUrl><![CDATA[this is a url]]></PicUrl>\n" +
                " <MediaId><![CDATA[media_id]]></MediaId>\n" +
                " <MsgId>1234567890123456</MsgId>\n" +
                " </xml>";
        System.out.println(str);
        System.out.println("##################################################");
        WXMessageBase receiveMessage = WXXMLUtil.xmlToBean(str, WXMessageBase.class);
        String xml = WXXMLUtil.beanToXml(receiveMessage, "UTF-8");
        System.out.println(xml);
    }

    public void testBeanToXml() throws Exception {

    }
}
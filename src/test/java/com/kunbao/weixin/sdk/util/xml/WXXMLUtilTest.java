package com.kunbao.weixin.sdk.util.xml;

import com.kunbao.weixin.sdk.message.domain.send.xml.WXSendText;
import junit.framework.TestCase;

/**
 * Created by lemon_bar on 15/7/17.
 */
public class WXXMLUtilTest extends TestCase {

    public void testBeanToXml() throws Exception {
        WXSendText text = new WXSendText("123", "321", "content");
        String xml =  WXXMLUtil.beanToXml(text);
    }
}
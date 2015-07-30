package com.kunbao.weixin.sdk.message.request;

import com.kunbao.weixin.sdk.message.domain.template.ItemValue;
import com.kunbao.weixin.sdk.message.domain.template.MessageInfo;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by lemon_bar on 15/7/30.
 */
public class WXTemplateSendRequestTest extends TestCase {

    public void testCreateResponse() throws Exception {
        MessageInfo messageInfo = new MessageInfo("openid", "templateid", "url", "topcolor");
        messageInfo.addItem("test1",new ItemValue("value1","color1"));
        messageInfo.addItem("test2",new ItemValue("value2","color2"));
        WXTemplateSendRequest request = new WXTemplateSendRequest("test", messageInfo);
        Assert.assertNotNull(request);
    }
}
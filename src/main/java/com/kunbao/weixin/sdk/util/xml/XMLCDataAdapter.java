package com.kunbao.weixin.sdk.util.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by lemon_bar on 15/7/1.
 */
public class XMLCDataAdapter extends XmlAdapter<String, String> {
    @Override
    public String unmarshal(String str) throws Exception {
        return str;
    }

    @Override
    public String marshal(String str) throws Exception {
        return "<![CDATA[" + str + "]]>";
    }
}

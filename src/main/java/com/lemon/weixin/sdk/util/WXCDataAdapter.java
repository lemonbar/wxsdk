package com.lemon.weixin.sdk.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by lemon_bar on 2014/12/9.
 */
public class WXCDataAdapter extends XmlAdapter<String, String> {
    @Override
    public String unmarshal(String str) throws Exception {
        return str;
    }

    @Override
    public String marshal(String str) throws Exception {
        return "<![CDATA[" + str + "]]>";
    }
}

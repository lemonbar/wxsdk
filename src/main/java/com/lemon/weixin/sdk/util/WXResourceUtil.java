package com.lemon.weixin.sdk.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by limeng0402 on 14-12-7.
 */
public class WXResourceUtil {
    public static String getResourceFullPath(String file) {
        String filePath = WXResourceUtil.class.getClassLoader().getResource(file).getPath();
        //decode url for utf-8 chars in image path.
        try {
            filePath = URLDecoder.decode(filePath, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return filePath;
    }
}

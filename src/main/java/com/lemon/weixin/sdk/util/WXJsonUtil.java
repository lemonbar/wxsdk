package com.lemon.weixin.sdk.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

/**
 * Created by lemon_bar on 2014/12/4.
 */
public class WXJsonUtil {

    public static <T> T jsonToBean(String jsonStr, Class<T> cls) {
        try {
            return new Gson().fromJson(jsonStr, cls);
        } catch (JsonSyntaxException e) {
            return null;
        }
    }

    public static String beanToJson(Object src) {
        return new GsonBuilder().disableHtmlEscaping().create().toJson(src, src.getClass());
    }
}

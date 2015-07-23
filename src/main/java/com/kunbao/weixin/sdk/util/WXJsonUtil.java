package com.kunbao.weixin.sdk.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kunbao.weixin.sdk.base.exception.WXException;

import java.io.IOException;

/**
 * Created by lemon_bar on 15/7/7.
 */
public class WXJsonUtil {
    private static ObjectMapper mapper;

    public static <T> T jsonToBean(String jsonStr, Class<T> cls) throws WXException {
        try {
            return getMapper().readValue(jsonStr, cls);
        } catch (IOException e) {
            throw new WXException(e.getMessage());
        }
    }

    private static ObjectMapper getMapper() {
        if (mapper == null) {
            mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        }
        return mapper;
    }

    public static String beanToJson(Object src) throws WXException {
        try {
            // Convert object to JSON string
            return getMapper().writeValueAsString(src);
        } catch (JsonProcessingException e) {
            throw new WXException(e.getMessage());
        }
    }
}

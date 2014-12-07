package com.lemon.weixin.sdk.base;

import com.lemon.weixin.sdk.base.constants.WXApiUrl;
import com.lemon.weixin.sdk.base.model.WXShortUrlAction;
import com.lemon.weixin.sdk.base.model.WXShortUrlResponse;
import com.lemon.weixin.sdk.util.WXHttpUtil;
import com.lemon.weixin.sdk.util.WXJsonUtil;

/**
 * Created by limeng0402 on 14-12-7.
 */
public class WXBaseService {

    public String longToShortUrl(String accessToken, WXShortUrlAction action) {
        String url = WXApiUrl.getShortUrl(accessToken);
        String jsonBody = WXJsonUtil.beanToJson(action);
        String response = WXHttpUtil.doPost(url, jsonBody);
        WXShortUrlResponse result = WXJsonUtil.jsonToBean(response, WXShortUrlResponse.class);
        if (result.getErrcode() == 0) {
            return result.getShort_url();
        }
        return null;
    }
}

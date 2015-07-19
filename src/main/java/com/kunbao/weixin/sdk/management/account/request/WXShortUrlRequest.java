package com.kunbao.weixin.sdk.management.account.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.management.account.domain.Long2ShortAction;
import com.kunbao.weixin.sdk.management.account.response.WXShortUrlResponse;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

/**
 * Created by lemon_bar on 15/7/10.
 */
public class WXShortUrlRequest extends WXRequest<WXShortUrlResponse> {

    public WXShortUrlRequest(String token, Long2ShortAction long2ShortAction) {
        super();
        this.method = WXHTTPMethod.POST;
        this.path = "/cgi-bin/shorturl";
        this.addParameter("access_token", token);
        this.body = WXJsonUtil.beanToJson(long2ShortAction);
    }

    @Override
    public WXShortUrlResponse createResponse(String body) {
        return WXJsonUtil.jsonToBean(body, WXShortUrlResponse.class);
    }
}

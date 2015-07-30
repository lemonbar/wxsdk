package com.kunbao.weixin.sdk.message.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.message.domain.template.ShortId;
import com.kunbao.weixin.sdk.message.response.WXTemplateIdGetResponse;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

/**
 * http请求方式: POST
 * https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN
 * Created by lemon_bar on 15/7/30.
 */
public class WXTemplateIdGetRequest extends WXRequest<WXTemplateIdGetResponse> {
    public WXTemplateIdGetRequest(String token, ShortId shortId) throws WXException {
        super();
        this.method = WXHTTPMethod.POST;
        this.path = "/cgi-bin/template/api_add_template";
        this.addParameter("access_token", token);
        this.body = WXJsonUtil.beanToJson(shortId);
    }

    @Override
    public WXTemplateIdGetResponse createResponse(String body) throws WXException {
        return WXJsonUtil.jsonToBean(body, WXTemplateIdGetResponse.class);
    }
}

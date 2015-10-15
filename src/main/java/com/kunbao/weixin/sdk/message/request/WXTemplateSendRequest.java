package com.kunbao.weixin.sdk.message.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.message.domain.template.MessageInfo;
import com.kunbao.weixin.sdk.message.response.WXTemplateSendResponse;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

/**
 * http请求方式: POST
 * https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN
 * Created by lemon_bar on 15/7/30.
 */
public class WXTemplateSendRequest extends WXRequest<WXTemplateSendResponse> {
    public WXTemplateSendRequest(String token, MessageInfo messageInfo) throws WXException {
        super();
        this.method = WXHTTPMethod.POST;
        this.path = "/cgi-bin/message/template/send";
        this.addParameter("access_token", token);
        this.body = WXJsonUtil.beanToJson(messageInfo);
    }

    @Override
    public WXTemplateSendResponse createResponse(String body) throws WXException {
        return WXJsonUtil.jsonToBean(body, WXTemplateSendResponse.class);
    }
}

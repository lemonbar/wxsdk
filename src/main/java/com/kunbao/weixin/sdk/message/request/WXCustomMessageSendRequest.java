package com.kunbao.weixin.sdk.message.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import com.kunbao.weixin.sdk.message.domain.send.json.*;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

/**
 * http请求方式: POST
 * https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN
 * Created by lemon_bar on 15/7/23.
 */
public class WXCustomMessageSendRequest extends WXRequest<WXJsonResponse> {
    private WXCustomMessageSendRequest(String token) {
        super();
        this.method = WXHTTPMethod.POST;
        this.path = "/cgi-bin/message/custom/send";
        this.addParameter("access_token", token);
    }

    public WXCustomMessageSendRequest(String token, WXCustomText text) throws WXException {
        this(token);
        this.body = WXJsonUtil.beanToJson(text);
    }

    public WXCustomMessageSendRequest(String token, WXCustomImage image) throws WXException {
        this(token);
        this.body = WXJsonUtil.beanToJson(image);
    }

    public WXCustomMessageSendRequest(String token, WXCustomVoice voice) throws WXException {
        this(token);
        this.body = WXJsonUtil.beanToJson(voice);
    }

    public WXCustomMessageSendRequest(String token, WXCustomVideo video) throws WXException {
        this(token);
        this.body = WXJsonUtil.beanToJson(video);
    }

    public WXCustomMessageSendRequest(String token, WXCustomMusic music) throws WXException {
        this(token);
        this.body = WXJsonUtil.beanToJson(music);
    }

    public WXCustomMessageSendRequest(String token, WXCustomNews news) throws WXException {
        this(token);
        this.body = WXJsonUtil.beanToJson(news);
    }

    @Override
    public WXJsonResponse createResponse(String body) throws WXException {
        return WXJsonUtil.jsonToBean(body, WXJsonResponse.class);
    }
}

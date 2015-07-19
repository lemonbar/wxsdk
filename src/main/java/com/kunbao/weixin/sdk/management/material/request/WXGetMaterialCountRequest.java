package com.kunbao.weixin.sdk.management.material.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.management.material.response.WXGetMaterialCountResponse;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

/**
 * http请求方式: GET
 * https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN
 * Created by lemon_bar on 15/7/12.
 */
public class WXGetMaterialCountRequest extends WXRequest<WXGetMaterialCountResponse> {
    public WXGetMaterialCountRequest(String token) {
        super();
        this.method = WXHTTPMethod.POST;
        this.path = "/cgi-bin/material/get_materialcount";
        this.addParameter("access_token", token);
    }

    @Override
    public WXGetMaterialCountResponse createResponse(String body) {
        return WXJsonUtil.jsonToBean(body, WXGetMaterialCountResponse.class);
    }
}

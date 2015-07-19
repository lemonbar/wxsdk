package com.kunbao.weixin.sdk.management.material.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import com.kunbao.weixin.sdk.management.material.domain.Material;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

/**
 * http请求方式: POST
 * https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN
 * Created by lemon_bar on 15/7/12.
 */
public class WXDeleteMaterialRequest extends WXRequest<WXJsonResponse> {
    public WXDeleteMaterialRequest(String token, Material material) {
        super();
        this.method = WXHTTPMethod.POST;
        this.path = "/cgi-bin/material/del_material";
        this.parameters.put("access_token", token);
        this.body = WXJsonUtil.beanToJson(material);
    }

    @Override
    public WXJsonResponse createResponse(String body) {
        return WXJsonUtil.jsonToBean(body, WXJsonResponse.class);
    }
}

package com.kunbao.weixin.sdk.management.material.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import com.kunbao.weixin.sdk.management.material.domain.MaterialPageableRequest;
import com.kunbao.weixin.sdk.management.material.domain.constant.MaterialType;
import com.kunbao.weixin.sdk.management.material.response.WXGetCommonMaterialListResponse;
import com.kunbao.weixin.sdk.management.material.response.WXGetNewsMaterialListResponse;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

/**
 * http请求方式: POST
 * https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN
 * {
 * "type":TYPE,
 * "offset":OFFSET,
 * "count":COUNT
 * }
 * Created by lemon_bar on 15/7/12.
 */
public class WXGetMaterialListRequest extends WXRequest<WXJsonResponse> {
    private MaterialType type;

    public WXGetMaterialListRequest(String token, MaterialPageableRequest pageableRequest) throws WXException {
        super();
        this.method = WXHTTPMethod.POST;
        this.path = "/cgi-bin/material/batchget_material";
        this.addParameter("access_token", token);
        this.body = WXJsonUtil.beanToJson(pageableRequest);
        this.type = pageableRequest.getType();
    }

    @Override
    public WXJsonResponse createResponse(String body) throws WXException {
        if (type.equals(MaterialType.news)) {
            return WXJsonUtil.jsonToBean(body, WXGetNewsMaterialListResponse.class);
        } else {
            return WXJsonUtil.jsonToBean(body, WXGetCommonMaterialListResponse.class);
        }
    }
}

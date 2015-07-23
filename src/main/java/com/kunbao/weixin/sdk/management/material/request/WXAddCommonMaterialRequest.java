package com.kunbao.weixin.sdk.management.material.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.management.material.response.WXAddCommonMaterialResponse;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

/**
 * http请求方式: POST，需使用https
 * https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN
 * 调用示例（使用curl命令，用FORM表单方式新增一个其他类型的永久素材，curl命令的使用请自行查阅资料）
 * Created by lemon_bar on 15/7/12.
 */
public class WXAddCommonMaterialRequest extends WXRequest<WXAddCommonMaterialResponse> {
    public WXAddCommonMaterialRequest(String token, String filePath) {
        super();
        this.method = WXHTTPMethod.UPLOAD;
        this.path = "/cgi-bin/material/add_material";
        this.parameters.put("access_token", token);
        this.filePath = filePath;
    }

    @Override
    public WXAddCommonMaterialResponse createResponse(String body) throws WXException {
        return WXJsonUtil.jsonToBean(body, WXAddCommonMaterialResponse.class);
    }
}

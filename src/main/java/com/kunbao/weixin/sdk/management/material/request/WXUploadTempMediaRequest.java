package com.kunbao.weixin.sdk.management.material.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.management.material.domain.constant.MediaType;
import com.kunbao.weixin.sdk.management.material.response.WXUploadTempMediaResponse;
import com.kunbao.weixin.sdk.util.WXJsonUtil;

/**
 * Created by jiang on 2015/7/12.
 */
public class WXUploadTempMediaRequest extends WXRequest<WXUploadTempMediaResponse> {
    public WXUploadTempMediaRequest(String token, MediaType type, String filePath) {
        super();
        this.method = WXHTTPMethod.UPLOAD;
        this.path = "/cgi-bin/media/upload";
        this.addParameter("access_token", token);
        this.addParameter("type", type.toString());
        this.filePath = filePath;
    }

    @Override
    public WXUploadTempMediaResponse createResponse(String body) {
        return WXJsonUtil.jsonToBean(body, WXUploadTempMediaResponse.class);
    }
}

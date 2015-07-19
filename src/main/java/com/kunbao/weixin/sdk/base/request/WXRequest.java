package com.kunbao.weixin.sdk.base.request;

import com.kunbao.weixin.sdk.base.domain.constant.WXBaseUrl;
import com.kunbao.weixin.sdk.base.domain.constant.WXHTTPMethod;
import com.kunbao.weixin.sdk.base.response.WXResponse;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lemon_bar on 15/7/7.
 */
public abstract class WXRequest<T extends WXResponse> {
    @Getter
    protected WXHTTPMethod method = WXHTTPMethod.GET;
    @Getter
    protected Map<String, String> parameters;
    protected String path;
    @Getter
    protected String body;
    protected String baseUrl;
    @Getter
    protected String filePath;

    public WXRequest() {
        this(WXBaseUrl.COMMON);
    }

    public WXRequest(String baseUrl) {
        this.baseUrl = baseUrl;
        this.parameters = new HashMap<String, String>();
    }

    public String getUrl() {
        return baseUrl + path;
    }

    public void addParameter(String key, String value) {
        this.parameters.put(key, value);
    }

    public abstract T createResponse(String body);
}

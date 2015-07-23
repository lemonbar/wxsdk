package com.kunbao.weixin.sdk.base;

import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import com.kunbao.weixin.sdk.base.response.WXJsonResponseChecker;
import com.kunbao.weixin.sdk.base.response.WXResponse;
import com.kunbao.weixin.sdk.util.WXHttpUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by lemon_bar on 15/7/7.
 */
public class WXHttpDispatch {
    private final static String CharSet = "UTF-8";

    private final static String URL_FORMAT = "%s?%s";

    public static WXResponse execute(WXRequest request) throws WXException {
        WXResponse wxResponse = null;
        switch (request.getMethod()) {
            case GET:
                wxResponse = doGet(request);
                break;
            case POST:
                wxResponse = doPost(request);
                break;
            case UPLOAD:
                wxResponse = doUpload(request);
                break;
            default:
                throw new WXException("undefined request method.");
        }
        if (wxResponse == null) {
            throw new WXException("response is null");
        }
        if (wxResponse instanceof WXJsonResponse) {
            WXJsonResponseChecker.check((WXJsonResponse) wxResponse);
        }
        return wxResponse;
    }

    private static WXResponse doGet(WXRequest request) {
        String url = String.format(URL_FORMAT,
                request.getUrl(),
                constructQuery(request.getParameters()));
        return request.createResponse(WXHttpUtil.doGet(url));
    }

    private static WXResponse doPost(WXRequest request) {
        String url = String.format(URL_FORMAT,
                request.getUrl(),
                constructQuery(request.getParameters()));
        return request.createResponse(WXHttpUtil.doPost(url, request.getBody()));
    }

    private static WXResponse doUpload(WXRequest request) {
        String url = String.format(URL_FORMAT,
                request.getUrl(),
                constructQuery(request.getParameters()));
        return request.createResponse(WXHttpUtil.doUpload(url, request.getFilePath()));
    }

    private static String constructQuery(Map<String, String> parameters) {
        try {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : parameters.entrySet()) {
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(URLEncoder.encode(entry.getValue(), CharSet));
                sb.append("&");
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

}

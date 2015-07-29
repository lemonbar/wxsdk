package com.kunbao.weixin.sdk.datacube.article.request;

import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.request.WXRequest;
import com.kunbao.weixin.sdk.datacube.article.response.WXArticleUserShareGetResponse;

/**
 * https://api.weixin.qq.com/datacube/getusershare?access_token=ACCESS_TOKEN
 * Created by lemon_bar on 15/7/29.
 */
public class WXArticleUserShareGetRequest extends WXRequest<WXArticleUserShareGetResponse> {
    @Override
    public WXArticleUserShareGetResponse createResponse(String body) throws WXException {
        return null;
    }
}

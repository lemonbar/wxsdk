package com.kunbao.weixin.sdk.management.material;

import com.kunbao.weixin.sdk.base.WXHttpDispatch;
import com.kunbao.weixin.sdk.base.domain.constant.WXBaseUrl;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.base.response.WXJsonResponse;
import com.kunbao.weixin.sdk.management.material.domain.Material;
import com.kunbao.weixin.sdk.management.material.domain.MaterialPageableRequest;
import com.kunbao.weixin.sdk.management.material.domain.NewsList;
import com.kunbao.weixin.sdk.management.material.domain.constant.MediaType;
import com.kunbao.weixin.sdk.management.material.request.*;
import com.kunbao.weixin.sdk.management.material.response.*;
import com.kunbao.weixin.sdk.token.WXTokenController;

/**
 * Created by lemon_bar on 15/7/12.
 */
public class WXMaterialService {
    private final String mediaUrlFormat = "/cgi-bin/media/get?access_token=%s&media_id=%s";

    public WXGetMaterialCountResponse getCount() throws WXException {
        WXGetMaterialCountRequest request = new WXGetMaterialCountRequest(WXTokenController.getToken());
        WXGetMaterialCountResponse response = (WXGetMaterialCountResponse) WXHttpDispatch.execute(request);
        return response;
    }

    public WXGetCommonMaterialListResponse getCommonMaterialList(MaterialPageableRequest pageableRequest) throws WXException {
        WXGetMaterialListRequest request = new WXGetMaterialListRequest(WXTokenController.getToken(), pageableRequest);
        WXGetCommonMaterialListResponse response = (WXGetCommonMaterialListResponse) WXHttpDispatch.execute(request);
        return response;
    }

    public WXGetNewsMaterialListResponse getNewsMaterialList(MaterialPageableRequest pageableRequest) throws WXException {
        WXGetMaterialListRequest request = new WXGetMaterialListRequest(WXTokenController.getToken(), pageableRequest);
        WXGetNewsMaterialListResponse response = (WXGetNewsMaterialListResponse) WXHttpDispatch.execute(request);
        return response;
    }

    public String uploadTempMedia(MediaType type, String filePath) throws WXException {
        WXUploadTempMediaRequest request = new WXUploadTempMediaRequest(WXTokenController.getToken(), type, filePath);
        WXUploadTempMediaResponse response = (WXUploadTempMediaResponse) WXHttpDispatch.execute(request);
        return getMediaUrl(WXTokenController.getToken(), response.getMediaId());
    }

    public WXAddNewsResponse addNewsList(NewsList newsList) throws WXException {
        WXAddNewsRequest request = new WXAddNewsRequest(WXTokenController.getToken(), newsList);
        WXAddNewsResponse response = (WXAddNewsResponse) WXHttpDispatch.execute(request);
        return response;
    }

    public WXAddCommonMaterialResponse addCommonMaterial(String filePath) throws WXException {
        WXAddCommonMaterialRequest request = new WXAddCommonMaterialRequest(WXTokenController.getToken(), filePath);
        WXAddCommonMaterialResponse response = (WXAddCommonMaterialResponse) WXHttpDispatch.execute(request);
        return response;
    }

    public boolean deleteMaterial(String mediaId) throws WXException {
        Material material = new Material(mediaId);
        WXDeleteMaterialRequest request = new WXDeleteMaterialRequest(WXTokenController.getToken(), material);
        WXJsonResponse response = (WXJsonResponse) WXHttpDispatch.execute(request);
        return response.isSuccess();
    }

    private String getMediaUrl(String token, String mediaId) {
        return WXBaseUrl.COMMON + String.format(mediaUrlFormat, token, mediaId);
    }
}

package com.kunbao.weixin.sdk.management.material;

import com.kunbao.weixin.sdk.base.WXHttpDispatch;
import com.kunbao.weixin.sdk.base.domain.constant.WXBaseUrl;
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
    private static String mediaUrlFormat = "/cgi-bin/media/get?access_token=%s&media_id=%s";

    public static WXGetMaterialCountResponse getCount() {
        WXGetMaterialCountRequest request = new WXGetMaterialCountRequest(WXTokenController.getToken());
        WXGetMaterialCountResponse response = (WXGetMaterialCountResponse) WXHttpDispatch.execute(request);
        return response;
    }

    public static WXGetCommonMaterialListResponse getCommonMaterialList(MaterialPageableRequest pageableRequest) {
        WXGetMaterialListRequest request = new WXGetMaterialListRequest(WXTokenController.getToken(), pageableRequest);
        WXGetCommonMaterialListResponse response = (WXGetCommonMaterialListResponse) WXHttpDispatch.execute(request);
        return response;
    }

    public static WXGetNewsMaterialListResponse getNewsMaterialList(MaterialPageableRequest pageableRequest) {
        WXGetMaterialListRequest request = new WXGetMaterialListRequest(WXTokenController.getToken(), pageableRequest);
        WXGetNewsMaterialListResponse response = (WXGetNewsMaterialListResponse) WXHttpDispatch.execute(request);
        return response;
    }

    public static String uploadTempMedia(MediaType type, String filePath) {
        WXUploadTempMediaRequest request = new WXUploadTempMediaRequest(WXTokenController.getToken(), type, filePath);
        WXUploadTempMediaResponse response = (WXUploadTempMediaResponse) WXHttpDispatch.execute(request);
        return getMediaUrl(WXTokenController.getToken(), response.getMediaId());
    }

    public static WXAddNewsResponse addNewsList(NewsList newsList) {
        WXAddNewsRequest request = new WXAddNewsRequest(WXTokenController.getToken(), newsList);
        WXAddNewsResponse response = (WXAddNewsResponse) WXHttpDispatch.execute(request);
        return response;
    }

    public static WXAddCommonMaterialResponse addCommonMaterial(String filePath) {
        WXAddCommonMaterialRequest request = new WXAddCommonMaterialRequest(WXTokenController.getToken(), filePath);
        WXAddCommonMaterialResponse response = (WXAddCommonMaterialResponse) WXHttpDispatch.execute(request);
        return response;
    }

    public static WXJsonResponse deleteMaterial(String mediaId) {
        Material material = new Material(mediaId);
        WXDeleteMaterialRequest request = new WXDeleteMaterialRequest(WXTokenController.getToken(), material);
        WXJsonResponse response = (WXJsonResponse) WXHttpDispatch.execute(request);
        return response;
    }

    private static String getMediaUrl(String token, String mediaId) {
        return WXBaseUrl.COMMON + String.format(mediaUrlFormat, token, mediaId);
    }
}

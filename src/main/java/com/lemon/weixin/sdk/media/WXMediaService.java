package com.lemon.weixin.sdk.media;

import com.lemon.weixin.sdk.base.constants.WXApiUrl;
import com.lemon.weixin.sdk.util.WXHttpUtil;

/**
 * Created by lemon_bar on 2014/12/5.
 */
public class WXMediaService {
    public String uploadImage(String accessToken, String imagePath) {
        return uploadMedia(accessToken, "image", imagePath);
    }

    public String uploadMedia(String accessToken, String type, String mediaPath) {
        String url = WXApiUrl.getMediaUploadUrl(accessToken, type);

        return WXHttpUtil.doUpload(url, mediaPath);
    }
}

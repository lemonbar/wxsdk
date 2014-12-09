package com.lemon.weixin.sdk.media;

import com.lemon.weixin.sdk.base.constants.WXApiUrl;
import com.lemon.weixin.sdk.media.resp.WXMedia;
import com.lemon.weixin.sdk.util.WXHttpUtil;
import com.lemon.weixin.sdk.util.WXJsonUtil;

/**
 * Created by lemon_bar on 2014/12/5.
 */
public class WXMediaService {
    public WXMedia uploadImage(String accessToken, String imagePath) {
        return uploadMedia(accessToken, "image", imagePath);
    }

    public WXMedia uploadMedia(String accessToken, String type, String mediaPath) {
        String url = WXApiUrl.getMediaUploadUrl(accessToken, type);
        try {
            String response = WXHttpUtil.doUpload(url, mediaPath);
            if (response != null) {
                return WXJsonUtil.jsonToBean(response, WXMedia.class);
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
}

package com.lemon.weixin.sdk.message.receive.req;

import lombok.Data;

/**
 * Created by lemon_bar on 2014/12/9.
 */
@Data
public class WXImageMessage extends WXBaseMessage {
    //图片链接
    private String PicUrl;
    //图片消息媒体id，可以调用多媒体文件下载接口拉取数据
    private String MediaId;
}
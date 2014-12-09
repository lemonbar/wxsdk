package com.lemon.weixin.sdk.message.receive.req;

import lombok.Data;

/**
 * Created by lemon_bar on 2014/12/9.
 */
@Data
public class WXVideoMessage extends WXBaseMessage {
    //视频消息媒体id，可以调用多媒体文件下载接口拉取数据
    private String MediaId;
    //视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
    private String ThumbMediaId;
}
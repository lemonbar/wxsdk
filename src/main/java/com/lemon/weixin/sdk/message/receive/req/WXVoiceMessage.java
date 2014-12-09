package com.lemon.weixin.sdk.message.receive.req;

import lombok.Data;

/**
 * Created by lemon_bar on 2014/12/9.
 */
@Data
public class WXVoiceMessage extends WXBaseMessage {
    //语音消息媒体id，可以调用多媒体文件下载接口拉取数据
    private String MediaId;
    //语音格式，如amr，speex等
    private String Format;
}
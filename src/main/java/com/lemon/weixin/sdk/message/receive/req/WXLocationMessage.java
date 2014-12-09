package com.lemon.weixin.sdk.message.receive.req;

import lombok.Data;

/**
 * Created by lemon_bar on 2014/12/9.
 */
@Data
public class WXLocationMessage extends WXBaseMessage {
    //地理位置维度
    private String Location_X;
    //地理位置经度
    private String Location_Y;
    //地图缩放大小
    private String Scale;
    //地理位置信息
    private String Label;
}
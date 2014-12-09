package com.lemon.weixin.sdk.message.receive.req;

import lombok.Data;

/**
 * Created by lemon_bar on 2014/12/9.
 */
@Data
public class WXLinkMessage extends WXBaseMessage {
    //消息标题
    private String Title;
    //消息描述
    private String Description;
    //消息链接
    private String Url;
}
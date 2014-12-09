package com.lemon.weixin.sdk.message.receive.req;

import lombok.Data;

/**
 * Created by lemon_bar on 2014/12/9.
 */
@Data
public class WXTextMessage extends WXBaseMessage{
    //文本消息内容
    private String Content;
}

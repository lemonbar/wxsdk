package com.lemon.weixin.sdk.message.receive.resp;

import lombok.Data;

/**
 * Created by lemon_bar on 2014/12/9.
 */
@Data
public class WXTextMessage extends WXBaseMessage {
    //回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
    private String Content;
}

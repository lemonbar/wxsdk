package com.lemon.weixin.sdk.message.receive.resp;

import lombok.Data;

/**
 * Created by lemon_bar on 2014/12/9.
 */
@Data
public class WXVoiceMessage extends WXBaseMessage {
    private WXBaseMedia Voice;
}

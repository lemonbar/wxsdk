package com.lemon.weixin.sdk.qrcode.resp;

import lombok.Data;

/**
 * Created by limeng0402 on 14-12-7.
 */
@Data
public class WXQrcodeTicket {
    private String ticket;
    private long expire_seconds;
    private String url;
}

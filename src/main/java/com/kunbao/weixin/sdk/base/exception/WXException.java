package com.kunbao.weixin.sdk.base.exception;

import lombok.Getter;

/**
 * Created by lemon_bar on 15/7/23.
 */
public class WXException extends Exception {
    @Getter
    private long code;
    @Getter
    private String message;

    public WXException(long code, String message) {
        super(String.format("%d: %s", code, message));
    }

    public WXException(String message) {
        this(-1, message);
    }
}
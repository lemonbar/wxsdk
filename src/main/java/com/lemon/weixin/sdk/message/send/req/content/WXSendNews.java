package com.lemon.weixin.sdk.message.send.req.content;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by limeng0402 on 14-12-4.
 */
@Data
public class WXSendNews {
    private List<WXSendArticle> articles = new ArrayList<WXSendArticle>();
}

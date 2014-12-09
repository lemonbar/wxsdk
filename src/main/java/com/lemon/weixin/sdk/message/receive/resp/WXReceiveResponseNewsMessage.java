package com.lemon.weixin.sdk.message.receive.resp;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by lemon_bar on 2014/12/9.
 */
@XmlRootElement(name = "xml")
public class WXReceiveResponseNewsMessage extends WXReceiveResponseMessage {
    @XmlElement
    private long ArticleCount;
    @XmlElementWrapper(name = "Articles")
    @XmlElements({//表示或的关系，list中内容可以为以下两种类型
            @XmlElement(name = "item", type = WXReceiveResponseArticle.class)
    })
    private List<WXReceiveResponseArticle> Articles;
}
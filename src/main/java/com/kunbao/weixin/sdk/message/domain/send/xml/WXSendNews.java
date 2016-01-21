package com.kunbao.weixin.sdk.message.domain.send.xml;

import com.kunbao.weixin.sdk.message.domain.base.WXMessageBase;
import com.kunbao.weixin.sdk.message.domain.constant.WXMessageType;
import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by lemon_bar on 15/7/23.
 */
@Getter
@ToString(callSuper = true)
@XmlRootElement(name = "xml")
public class WXSendNews extends WXMessageBase {
    @XmlElement(name = "ArticleCount")
    private int articleCount;

    @XmlElement(name = "Articles")
    private List<WXSendNewsItem> articles;

    protected WXSendNews() {
        super();
    }

    public WXSendNews(String fromUser, String toUser, List<WXSendNewsItem> articles) {
        super(fromUser, toUser, WXMessageType.news.toString());
        this.articleCount = articles.size();
        this.articles = articles;
    }
}

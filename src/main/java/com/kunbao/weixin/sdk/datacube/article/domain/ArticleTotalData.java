package com.kunbao.weixin.sdk.datacube.article.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

/**
 * "ref_date": "2014-12-14",
 * "msgid": "202457380_1",
 * "title": "马航丢画记",
 * "details": [
 * {
 * Created by lemon_bar on 15/7/29.
 */
@Getter
public class ArticleTotalData {
    @JsonProperty("ref_date")
    private String refDate;
    @JsonProperty("msgid")
    private String msgId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("details")
    private List<ArticleTotalDataDetail> details;
}

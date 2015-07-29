package com.kunbao.weixin.sdk.datacube.article.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * "ref_hour": 1200,
 * Created by lemon_bar on 15/7/29.
 */
@Getter
public class ArticleShareHourData extends ArticleShareData {
    @JsonProperty("ref_hour")
    private int refHour;
}

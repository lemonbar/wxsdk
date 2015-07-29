package com.kunbao.weixin.sdk.datacube.article.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * Created by lemon_bar on 15/7/29.
 */
@Getter
public class UserReadHourData extends UserReadData {
    @JsonProperty("ref_hour")
    private int refHour;
    @JsonProperty("user_source")
    private int userSource;
}

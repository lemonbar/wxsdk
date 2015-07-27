package com.kunbao.weixin.sdk.datacube.user.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kunbao.weixin.sdk.base.exception.WXException;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * {
 * "begin_date": "2014-12-02",
 * "end_date": "2014-12-07"
 * }
 * Created by lemon_bar on 15/7/27.
 */
@Getter
public class DatePeriod {
    @JsonProperty("begin_date")
    private String begin;
    @JsonProperty("end_date")
    private String end;

    protected DatePeriod() {
    }

    public DatePeriod(Date start, Date end) throws WXException {
//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.DATE, 7);
//        Date expectedLargestDate = cal.getTime();
//        if (end.after(expectedLargestDate)) {
//            throw new WXException("end date - start date > 7 days.");
//        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.begin = dateFormat.format(start);
        this.end = dateFormat.format(end);
    }
}

package com.kunbao.weixin.sdk.jsapiticket;

import com.kunbao.weixin.sdk.base.WXHttpDispatch;
import com.kunbao.weixin.sdk.base.exception.WXException;
import com.kunbao.weixin.sdk.jsapiticket.request.WXJsapiTicketRequest;
import com.kunbao.weixin.sdk.jsapiticket.response.WXJsapiTicketResponse;
import com.kunbao.weixin.sdk.token.WXTokenController;
import lombok.Data;

import java.util.Date;

/**
 * Created by lemon_bar on 15/8/30.
 */
public class WXJsapiTicketController {
    private static JsapiTicket jsTicket;

    public synchronized static void parseAndStoreJsapiTicket() throws WXException {
        if (!isTicketValid()) {
            //get js api ticket.
            WXJsapiTicketRequest request = new WXJsapiTicketRequest(WXTokenController.getToken());
            WXJsapiTicketResponse response = (WXJsapiTicketResponse) WXHttpDispatch.execute(request);
            //store
            jsTicket = new JsapiTicket();
            jsTicket.setTicket(response.getTicket());
            jsTicket.setExpires_in(response.getExpires());
            jsTicket.setCreateDate(new Date());
        }
    }

    public static boolean isTicketValid() {
        return (jsTicket != null && !jsTicket.isExpired());
    }

    public static String getTicket() throws WXException {
        if (!isTicketValid()) {
            parseAndStoreJsapiTicket();
        }
        return jsTicket.getTicket();
    }

    @Data
    private static class JsapiTicket {
        private String ticket;
        private long expires_in;
        private Date createDate;

        public boolean isExpired() {
            //To make sure the token is available,
            // invalid the token 10 minutes in advance;
            Date date = new Date();
            long remainingTime = createDate.getTime() + expires_in * 1000 - date.getTime();
            long seconds = remainingTime / 1000;
            return seconds < 10 * 60;
        }
    }
}

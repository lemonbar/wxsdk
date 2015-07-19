package com.kunbao.weixin.sdk.util;

import com.kunbao.weixin.sdk.message.domain.constant.WXEventType;
import com.kunbao.weixin.sdk.message.domain.constant.WXMessageType;
import com.kunbao.weixin.sdk.util.xml.WXXMLUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lemon_bar on 15/7/3.
 */
public class WXParserUtil {
    private static final String MESSAGE_TYPE_PATTERN = "(?<=<MsgType><!\\[CDATA\\[)[a-zA-Z]+(?=\\]\\]></MsgType>)";
    private static final String EVENT_TYPE_PATTERN = "(?<=<Event><!\\[CDATA\\[)[A-Za-z]+(?=\\]\\]></Event>)";

    public static WXMessageType parserPushedMessageType(String requestMessage) {
        Pattern p = Pattern.compile(MESSAGE_TYPE_PATTERN);
        Matcher m = p.matcher(requestMessage);
        if (m.find()) {
            return WXMessageType.valueOf(m.group());
        }
        return null;
    }

    public static WXEventType parserPushedEventType(String requestMessage) {
        Pattern p = Pattern.compile(EVENT_TYPE_PATTERN);
        Matcher m = p.matcher(requestMessage);
        if (m.find()) {
            return WXEventType.valueOf(m.group());
        }
        return null;
    }

    public static <T> T parserMessage(String message, Class<T> messageClass) {
        return WXXMLUtil.xmlToBean(message, messageClass);
    }

}

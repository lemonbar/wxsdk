package com.lemon.weixin.sdk.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * Created by lemon_bar on 2014/12/4.
 */
public class WXXmlUtil {
    public static <T> T xmlToBean(String xmlStr, Class<T> beanClass) {
        Reader reader = new StringReader(xmlStr);
        Unmarshaller unmarshaller;
        try {
            unmarshaller = JAXBContext.newInstance(beanClass).createUnmarshaller();
            return (T) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}

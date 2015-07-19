package com.kunbao.weixin.sdk.util.xml;

import com.sun.xml.bind.marshaller.CharacterEscapeHandler;
import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * Created by lemon_bar on 15/7/1.
 */
@Slf4j
public class WXXMLUtil {
    private final static String DEFAULT_ENCODING_CHARACTER = "UTF-8";

    public static <T> T xmlToBean(String xmlStr, Class<T> beanClass) {
        Reader reader = new StringReader(xmlStr);
        Unmarshaller unmarshaller;
        try {
            unmarshaller = JAXBContext.newInstance(beanClass).createUnmarshaller();
            return (T) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            log.error(e.getMessage());
            return null;
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return null;
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String beanToXml(Object obj) {
        return beanToXml(obj, DEFAULT_ENCODING_CHARACTER);
    }

    public static String beanToXml(Object obj, String encoding) {
        String result = null;
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            marshaller.setProperty(CharacterEscapeHandler.class.getName(),
                    new CharacterEscapeHandler() {
                        @Override
                        public void escape(char[] ch, int start, int length, boolean isAttVal,
                                           Writer writer) throws IOException {
                            writer.write(ch, start, length);
                        }
                    });
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            result = writer.toString();
        } catch (Exception e) {
            log.error(e.getMessage());
//            System.out.println(e.getMessage());
        }
        return result;
    }
}

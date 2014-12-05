package com.lemon.weixin.sdk.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by lemon_bar on 2014/12/4.
 */
public class WXHttpUtil {
    private final static String DEFAULT_CHARACTER_SET = "UTF-8";

    public static String doGet(String URL) {
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        try {
            client = HttpClients.createDefault();
            HttpGet req = new HttpGet(URL);
            response = client.execute(req);
            HttpEntity resEntity = response.getEntity();
            return EntityUtils.toString(resEntity, DEFAULT_CHARACTER_SET);
        } catch (IOException e) {
            //todo;
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (client != null) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String doPost(String URL, String body) {
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        try {
            client = HttpClients.createDefault();
            HttpPost req = new HttpPost(URL);
            req.setEntity(new StringEntity(body, DEFAULT_CHARACTER_SET));
            response = client.execute(req);
            HttpEntity resEntity = response.getEntity();
            return EntityUtils.toString(resEntity, DEFAULT_CHARACTER_SET);
        } catch (IOException e) {
            //todo;
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (client != null) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String doUpload(String URL, String file) {
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        try {
            client = HttpClients.createDefault();
            HttpPost req = new HttpPost(URL);
            FileBody fileBody = new FileBody(new File(file));
            HttpEntity reqEntity = MultipartEntityBuilder.create()
                    .setCharset(Charset.forName(DEFAULT_CHARACTER_SET))
                    .addPart("media", fileBody)
                    .build();
            req.setEntity(reqEntity);
            response = client.execute(req);
            HttpEntity resEntity = response.getEntity();
            return EntityUtils.toString(resEntity, DEFAULT_CHARACTER_SET);
        } catch (IOException e) {
            //todo;
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (client != null) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

package com.lemon.weixin.sdk.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by lemon_bar on 2014/12/4.
 */
public class WXHttpUtil {
    public static String responseWithURL(String URL) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet req = new HttpGet(URL);
        try {
            CloseableHttpResponse response = client.execute(req);
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity);
        } catch (IOException e) {
            //todo;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String postResponseWithURL(String URL, String body) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost req = new HttpPost(URL);
        req.setEntity(new StringEntity(body, "utf-8"));
        try {
            CloseableHttpResponse response = client.execute(req);
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity);
        } catch (IOException e) {
            //todo;
        }
        return null;
    }
}

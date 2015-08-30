package com.kunbao.weixin.sdk.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by lemon_bar on 15/8/30.
 */
public class FileUtil {
    public static byte[] readUrlBytes(String mediaUrl) throws IOException {
        URL url = new URL(mediaUrl);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.connect();
        InputStream cin = httpConn.getInputStream();

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = cin.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        cin.close();
        byte[] fileData = outStream.toByteArray();
        outStream.close();
        return fileData;
    }
}

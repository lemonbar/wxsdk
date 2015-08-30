package com.kunbao.weixin.sdk.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Formatter;

/**
 * Created by lemon_bar on 15/7/7.
 */
public class WXSignatureUtil {

    /**
     * 1. 将token、timestamp、nonce三个参数进行字典序排序
     * 2. 将三个参数字符串拼接成一个字符串进行sha1加密
     * 3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
     *
     * @param signature 期望值
     * @param textArr
     * @return
     */
    public static boolean checkSignature(final String signature, final String... textArr) {
        Arrays.sort(textArr);
        final StringBuilder sb = new StringBuilder();
        for (final String s : textArr) {
            sb.append(s);
        }
        final String plainText = sb.toString();
        return DigestUtils.sha1Hex(plainText).equals(signature);
    }


    public static String genSignature(String jsapi_ticket, String url, String nonceStr, String timestamp) {
        String string1;
        String signature = null;

        //步骤1. 对所有待签名参数按照字段名的ASCII 码从小到大排序（字典序）后，
        // 使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串string1：
        //注意这里参数名必须全部小写，且必须有序
        string1 = "jsapi_ticket=" + jsapi_ticket +
                "&noncestr=" + nonceStr +
                "&timestamp=" + timestamp +
                "&url=" + url;
        System.out.println(string1);

        try {
            //步骤2. 对string1进行sha1签名，得到signature：
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return signature;
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
}

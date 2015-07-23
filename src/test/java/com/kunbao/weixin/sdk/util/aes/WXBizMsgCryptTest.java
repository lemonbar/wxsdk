package com.kunbao.weixin.sdk.util.aes;

import com.kunbao.weixin.sdk.base.domain.constant.WXAppConstant;
import org.junit.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class WXBizMsgCryptTest {
    String encodingAesKey = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFG";
    String token = "pamtest";
    String timestamp = "1409304348";
    String nonce = "xxxxxx";
    String appId = "wxb11529c136998cb6";
    String replyMsg = "我是中文abcd123";
    String xmlFormat = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";
    String afterAesEncrypt = "jn1L23DB+6ELqJ+6bruv21Y6MD7KeIfP82D6gU39rmkgczbWwt5+3bnyg5K55bgVtVzd832WzZGMhkP72vVOfg==";
    String randomStr = "aaaabbbbccccdddd";

    String replyMsg2 = "<xml><ToUserName><![CDATA[oia2Tj我是中文jewbmiOUlr6X-1crbLOvLw]]></ToUserName><FromUserName><![CDATA[gh_7f083739789a]]></FromUserName><CreateTime>1407743423</CreateTime><MsgType><![CDATA[video]]></MsgType><Video><MediaId><![CDATA[eYJ1MbwPRJtOvIEabaxHs7TX2D-HV71s79GUxqdUkjm6Gs2Ed1KF3ulAOA9H1xG0]]></MediaId><Title><![CDATA[testCallBackReplyVideo]]></Title><Description><![CDATA[testCallBackReplyVideo]]></Description></Video></xml>";
    String afterAesEncrypt2 = "jn1L23DB+6ELqJ+6bruv23M2GmYfkv0xBh2h+XTBOKVKcgDFHle6gqcZ1cZrk3e1qjPQ1F4RsLWzQRG9udbKWesxlkupqcEcW7ZQweImX9+wLMa0GaUzpkycA8+IamDBxn5loLgZpnS7fVAbExOkK5DYHBmv5tptA9tklE/fTIILHR8HLXa5nQvFb3tYPKAlHF3rtTeayNf0QuM+UW/wM9enGIDIJHF7CLHiDNAYxr+r+OrJCmPQyTy8cVWlu9iSvOHPT/77bZqJucQHQ04sq7KZI27OcqpQNSto2OdHCoTccjggX5Z9Mma0nMJBU+jLKJ38YB1fBIz+vBzsYjrTmFQ44YfeEuZ+xRTQwr92vhA9OxchWVINGC50qE/6lmkwWTwGX9wtQpsJKhP+oS7rvTY8+VdzETdfakjkwQ5/Xka042OlUb1/slTwo4RscuQ+RdxSGvDahxAJ6+EAjLt9d8igHngxIbf6YyqqROxuxqIeIch3CssH/LqRs+iAcILvApYZckqmA7FNERspKA5f8GoJ9sv8xmGvZ9Yrf57cExWtnX8aCMMaBropU/1k+hKP5LVdzbWCG0hGwx/dQudYR/eXp3P0XxjlFiy+9DMlaFExWUZQDajPkdPrEeOwofJb";

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testDecrypt() throws ParserConfigurationException, SAXException, IOException {
        //encrypteTyp: aes, msgSignature: 4972a1267ff568e8e5b84456f7a0f4006ad770a2, signature: 5bc996243bafcee7f30a63c7761e301f32ffc17e, timestamp: 1437107551, nonce: 1347370980
        String signature = "5bc996243bafcee7f30a63c7761e301f32ffc17e";
        String timestamp = "1437107551";
        String nonce = "1347370980";
        //在安全模式或兼容模式下，url上会新增两个参数encrypt_type和msg_signature。
        // encrypt_type表示加密类型，msg_signature:表示对消息体的签名。
        String encryptType = "aes";
        String msgSignature = "4972a1267ff568e8e5b84456f7a0f4006ad770a2";

        //解析，处理消息
        String requestMessage = "<xml>\n" +
                "    <ToUserName><![CDATA[gh_6bc2f16bcdba]]></ToUserName>\n" +
                "    <FromUserName><![CDATA[o6RpjuGLCkw6TH36e_Dm8b4t8clI]]></FromUserName>\n" +
                "    <CreateTime>1437107551</CreateTime>\n" +
                "    <MsgType><![CDATA[text]]></MsgType>\n" +
                "    <Content><![CDATA[你在哪？]]></Content>\n" +
                "    <MsgId>6172329932587288417</MsgId>\n" +
                "    <Encrypt><![CDATA[FgIGBaQZ99FVuTbu8ktqTGT+wisFMEUQxEe9fVyX1IWSqoRrBCSbnJOryEv78LK61/5hCW9fse8zFf86I+GgHb2VheewjF7lhjVzbp898o0vzMQsD1adoQu3poRugu2VD6Y1a3ObhGm78ee9b7FcbTnxw8Wyxm43mBQ0TV988Ne8kPKQH5jTi76KjRzdkbxhfT32i7znCkir9/7ogFpPnWkVTi4t6Pw6bJfyeOeKU6NUhy3+RN6XtE8XUoEUGSHONyKLEav7T8hnvAPe+KsL3SeObgNRvdH2RGcivDewqP1oJQ6E7RfxGmyf1/3Q/J6sFFDHX7mhA8ImpBUj33zE8hjV8wHaBmVfPWnhxF7c9z033iR362Lam9W9TKaZA3LnK7yixxTUyDRfa1baB1K/pz4MQhWVSgBJdv394Yyjjl3aGRTsPznYPyAUbtC6drHSPMXMXCjj99woPgpzVxLxeg==]]></Encrypt>\n" +
                "</xml>\n";

        // url上无encrypt_type参数或者其值为raw时表示为不加密；
        // encrypt_type为aes时，表示aes加密（暂时只有raw和aes两种值)。
        // 公众帐号开发者根据此参数来判断微信公众平台发送的消息是否加密。
        if ("aes".equals(encryptType)) {
            try {
                WXBizMsgCrypt msgCrypt = new WXBizMsgCrypt(WXAppConstant.TOKEN, WXAppConstant.EncodingAESKey, WXAppConstant.APP_ID);
                requestMessage = msgCrypt.decryptMsg(msgSignature, timestamp, nonce, requestMessage);
                System.out.println(requestMessage);
            } catch (AesException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }

    @Test
    public void testNormal() throws ParserConfigurationException, SAXException, IOException {
        try {
            WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingAesKey, appId);
            String afterEncrpt = pc.encryptMsg(replyMsg, timestamp, nonce);

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            StringReader sr = new StringReader(afterEncrpt);
            InputSource is = new InputSource(sr);
            Document document = db.parse(is);

            Element root = document.getDocumentElement();
            NodeList nodelist1 = root.getElementsByTagName("Encrypt");
            NodeList nodelist2 = root.getElementsByTagName("MsgSignature");

            String encrypt = nodelist1.item(0).getTextContent();
            String msgSignature = nodelist2.item(0).getTextContent();
            String fromXML = String.format(xmlFormat, encrypt);

            // 第三方收到公众号平台发送的消息
            String afterDecrpt = pc.decryptMsg(msgSignature, timestamp, nonce, fromXML);
            assertEquals(replyMsg, afterDecrpt);
        } catch (AesException e) {
            fail("正常流程，怎么就抛出异常了？？？？？？");
        }
    }

    @Test
    public void testAesEncrypt() {
        try {
            WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingAesKey, appId);
            assertEquals(afterAesEncrypt, pc.encrypt(randomStr, replyMsg));
        } catch (AesException e) {
            e.printStackTrace();
            fail("no异常");
        }
    }

    @Test
    public void testAesEncrypt2() {
        try {
            WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingAesKey, appId);
            assertEquals(afterAesEncrypt2, pc.encrypt(randomStr, replyMsg2));

        } catch (AesException e) {
            e.printStackTrace();
            fail("no异常");
        }
    }

    @Test
    public void testIllegalAesKey() {
        try {
            new WXBizMsgCrypt(token, "abcde", appId);
        } catch (AesException e) {
            assertEquals(AesException.IllegalAesKey, e.getCode());
            return;
        }
        fail("错误流程不抛出异常？？？");
    }

    @Test
    public void testValidateSignatureError() throws ParserConfigurationException, SAXException,
            IOException {
        try {
            WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingAesKey, appId);
            String afterEncrpt = pc.encryptMsg(replyMsg, timestamp, nonce);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            StringReader sr = new StringReader(afterEncrpt);
            InputSource is = new InputSource(sr);
            Document document = db.parse(is);

            Element root = document.getDocumentElement();
            NodeList nodelist1 = root.getElementsByTagName("Encrypt");

            String encrypt = nodelist1.item(0).getTextContent();
            String fromXML = String.format(xmlFormat, encrypt);
            pc.decryptMsg("12345", timestamp, nonce, fromXML); // 这里签名错误
        } catch (AesException e) {
            assertEquals(AesException.ValidateSignatureError, e.getCode());
            return;
        }
        fail("错误流程不抛出异常？？？");
    }

    @Test
    public void testVerifyUrl() throws AesException {
        WXBizMsgCrypt wxcpt = new WXBizMsgCrypt("QDG6eK",
                "jWmYm7qr5nMoAUwZRjGtBxmz3KA1tkAj3ykkR6q2B2C", "wx5823bf96d3bd56c7");
        String verifyMsgSig = "5c45ff5e21c57e6ad56bac8758b79b1d9ac89fd3";
        String timeStamp = "1409659589";
        String nonce = "263014780";
        String echoStr = "P9nAzCzyDtyTWESHep1vC5X9xho/qYX3Zpb4yKa9SKld1DsH3Iyt3tP3zNdtp+4RPcs8TgAE7OaBO+FZXvnaqQ==";
        wxcpt.verifyUrl(verifyMsgSig, timeStamp, nonce, echoStr);
        // 只要不抛出异常就好
    }
}

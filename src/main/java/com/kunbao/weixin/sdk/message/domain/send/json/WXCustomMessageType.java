package com.kunbao.weixin.sdk.message.domain.send.json;

/**
 * 消息类型，文本为text，图片为image，语音为voice，视频消息为video，
 * 音乐消息为music，图文消息为news，卡券为wxcard
 * Created by lemon_bar on 15/7/23.
 */
public enum WXCustomMessageType {
    text,
    image,
    voice,
    video,
    music,
    news,
    wxcard;
}

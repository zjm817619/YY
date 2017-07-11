package com.tarena.yy.linstener;

import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMMessage;

import java.util.List;

/**
 * Created by tarena on 2017/7/11.
 */

public class MyMessageListener implements EMMessageListener {

    @Override
    public void onMessageReceived(List<EMMessage> messages) {
        //收到消息
    }

    @Override
    public void onCmdMessageReceived(List<EMMessage> messages) {
        //收到透传消息

    }

    @Override
    public void onMessageRead(List<EMMessage> messages) {
        //收到已读回执

    }

    @Override
    public void onMessageDelivered(List<EMMessage> messages) {
        //收到已送达回执

    }

    @Override
    public void onMessageChanged(EMMessage message, Object change) {
        //消息状态变动

    }
}

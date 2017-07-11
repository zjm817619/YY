package com.tarena.yy;

import android.app.Application;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;

import cn.bmob.v3.Bmob;

/**
 * Created by tarena on 2017/7/11.
 */

public class MyApplication extends Application{
    public static MyApplication applicationContext;
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this,"486ecf8d5d077dcfc21d099484a53e69");
        EMOptions options = new EMOptions();
// 默认添加好友时，是不需要验证的，改成需要验证
        options.setAcceptInvitationAlways(false);
//初始化
        EMClient.getInstance().init(applicationContext, options);
//在做打包混淆时，关闭debug模式，避免消耗不必要的资源
        EMClient.getInstance().setDebugMode(true);

    }
}

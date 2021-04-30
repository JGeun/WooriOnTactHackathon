package jgeun.hackathon.wooriontact.config;

import android.app.Application;

import com.kakao.sdk.common.KakaoSdk;

import jgeun.hackathon.wooriontact.R;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        KakaoSdk.init(this, getString(R.string.kakao_native_appkey));
    }
}

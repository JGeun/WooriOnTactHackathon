package jgeun.hackathon.wooriontact.child.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import jgeun.hackathon.wooriontact.MainActivity;
import jgeun.hackathon.wooriontact.R;
import jgeun.hackathon.wooriontact.child.signup.ChildSignUpActivity;
import jgeun.hackathon.wooriontact.util.StatusBarUtil;

public class ChildSplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_splash);

        StatusBarUtil.setStatusBarColor(this, StatusBarUtil.StatusBarColorType.MAIN_COLOR_STATUS_BAR);
        Handler hd = new Handler();
        hd.postDelayed(new startIntent(), 1500);
    }

    public class startIntent implements Runnable{
        public void run(){
            startActivity(new Intent(getApplicationContext(), ChildSignUpActivity.class));
        }
    }
}
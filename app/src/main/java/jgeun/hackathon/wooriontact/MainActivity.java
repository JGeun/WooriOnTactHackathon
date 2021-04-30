package jgeun.hackathon.wooriontact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.kakao.sdk.common.util.Utility;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String hashKey = Utility.INSTANCE.getKeyHash(this);
        Log.d("카카오", hashKey);
    }
}
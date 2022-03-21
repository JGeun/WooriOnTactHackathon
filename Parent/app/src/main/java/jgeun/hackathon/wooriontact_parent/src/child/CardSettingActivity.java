package jgeun.hackathon.wooriontact_parent.src.child;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import jgeun.hackathon.wooriontact_parent.R;
import jgeun.hackathon.wooriontact_parent.src.mypage.MyPageActivity;

public class CardSettingActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout btn_finish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_setting);

        btn_finish = findViewById(R.id.setting_btn_finish);
        btn_finish.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.setting_btn_finish:
                startActivity(new Intent(this, MyPageActivity.class));
                break;
        }
    }
}
package jgeun.hackathon.wooriontact.child.makeCard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import jgeun.hackathon.wooriontact.R;
import jgeun.hackathon.wooriontact.child.mypage.ChildMyPageActivity;

public class MakeCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_card);

        findViewById(R.id.child_makecard_btn_finish).setOnClickListener(v ->{
           startActivity(new Intent(this, ChildMyPageActivity.class));
           finish();
        });

    }
}
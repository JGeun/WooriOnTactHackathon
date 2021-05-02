package jgeun.hackathon.wooriontact.child.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kakao.sdk.user.UserApiClient;

import jgeun.hackathon.wooriontact.R;
import jgeun.hackathon.wooriontact.child.makeCard.MakeCardActivity;

public class ChildProfileActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView checkButton;
    private ImageView returnButton;
    private LinearLayout makePayButton;
    private LinearLayout returnPageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_profile);

        Intent userIntent = getIntent();
        TextView userName = findViewById(R.id.child_profile_userName);
        userName.setText(userIntent.getStringExtra("name"));

        checkButton = findViewById(R.id.child_profile_checkButton);
        checkButton.setOnClickListener(this);
        returnButton = findViewById(R.id.child_profile_returnButton);
        returnButton.setOnClickListener(this);
        makePayButton = findViewById(R.id.child_profile_makePayButton);
        makePayButton.setOnClickListener(this);
        returnPageButton = findViewById(R.id.child_profile_returnPageButton);
        returnPageButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.child_profile_checkButton:
                makePayButton.setVisibility(View.VISIBLE);
                returnPageButton.setVisibility(View.GONE);
                break;
            case R.id.child_profile_returnButton:
                makePayButton.setVisibility(View.GONE);
                returnPageButton.setVisibility(View.VISIBLE);
                break;
            case R.id.child_profile_makePayButton:
                startActivity(new Intent(this, MakeCardActivity.class));
                break;
            case R.id.child_profile_returnPageButton:
                kakaoUnlink();
                finish();
                break;
        }
    }

    public void kakaoLogout(){
        UserApiClient.getInstance().logout(error ->{
            if (error != null) {
                Log.e("확인", "로그아웃 실패. SDK에서 토큰 삭제됨", error);
            }
            else {
                Log.i("확인", "로그아웃 성공. SDK에서 토큰 삭제됨");
            }
            return null;
        });
    }

    public void kakaoUnlink(){
        UserApiClient.getInstance().unlink(error ->{
            if (error != null) {
                Log.e("확인", "연결 끊기 실패", error);

            }
            else {
                Log.i("확인", "연결 끊기 성공. SDK에서 토큰 삭제 됨");
                finish();
            }
            return null;
        });
    }
}
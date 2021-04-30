package jgeun.hackathon.wooriontact.child.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.checkbox.MaterialCheckBox;
import com.kakao.sdk.talk.TalkApiClient;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.response.model.UserAccount;

import java.util.ArrayList;
import java.util.List;

import jgeun.hackathon.wooriontact.R;
import jgeun.hackathon.wooriontact.child.profile.ChildProfileActivity;

public class ChildSignUpActivity extends AppCompatActivity implements View.OnClickListener{

    private MaterialCheckBox checkBox1;
    private MaterialCheckBox checkBox2;
    private MaterialCheckBox checkBox3;
    private MaterialCheckBox checkBox4;
    private ImageView kakaoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_sign_up);

        checkBox1 = findViewById(R.id.child_signup_checkBox1);
        checkBox2 = findViewById(R.id.child_signup_checkBox2);
        checkBox3 = findViewById(R.id.child_signup_checkBox3);
        checkBox4 = findViewById(R.id.child_signup_checkBox4);

        kakaoLogin = findViewById(R.id.child_signup_kakaoLogin);
        kakaoLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.child_signup_kakaoLogin:
                if(isValidate()){
                    kakaoLogin();
                }else{
                    Toast.makeText(this, "모든 동의해 주세요.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public boolean isValidate(){
        if(checkBox1.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && checkBox4.isChecked()){
            return true;
        }else{
            return false;
        }
    }

    public void kakaoLogin(){
        UserApiClient.getInstance().loginWithKakaoTalk(ChildSignUpActivity.this, (token, loginError) -> {
            if (loginError != null) {
                Log.e("확인", "로그인 실패", loginError);
            } else if(token != null) {
                Log.d("확인", "로그인 성공");
                TalkApiClient.getInstance().profile((profile, error) -> {

                    if(error != null){
                        Log.e("확인", "카카오톡 프로필 가져오기 실패", error);
                    }else if (profile != null) {
                        Log.i("확인", "카카오톡 프로필 가져오기 성공" +
                                "\n닉네임: " + profile.getNickname());
                        Intent profileIntent = new Intent(this, ChildProfileActivity.class);
                        profileIntent.putExtra("name", profile.getNickname());
                        startActivity(profileIntent);
                    }
                    return null;
                });
            }
            return null;
        });
    }
}
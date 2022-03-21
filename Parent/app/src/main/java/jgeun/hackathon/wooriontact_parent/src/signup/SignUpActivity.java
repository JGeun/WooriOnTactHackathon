package jgeun.hackathon.wooriontact_parent.src.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import jgeun.hackathon.wooriontact_parent.R;
import jgeun.hackathon.wooriontact_parent.src.card.SelectMyCardActivity;
import jgeun.hackathon.wooriontact_parent.src.login.LoginActivity;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout connectButton;

    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        connectButton = findViewById(R.id.signup_btn_connect);
        connectButton.setOnClickListener(this);

        checkBox1 = findViewById(R.id.signup_checkBox1);
        checkBox2 = findViewById(R.id.signup_checkBox2);
        checkBox3 = findViewById(R.id.signup_checkBox3);
        checkBox4 = findViewById(R.id.signup_checkBox4);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signup_btn_connect:
                if(isValidate()){
                    startActivity(new Intent(this, LoginActivity.class));
                }else{
                    Toast.makeText(this, "모두 동의해주세요.", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }

    public boolean isValidate(){
        if(checkBox1.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && checkBox4.isChecked()) {
            return true;
        }else{
            return false;
        }
    }
}
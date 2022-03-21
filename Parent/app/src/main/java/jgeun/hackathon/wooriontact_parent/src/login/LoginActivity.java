package jgeun.hackathon.wooriontact_parent.src.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import jgeun.hackathon.wooriontact_parent.R;
import jgeun.hackathon.wooriontact_parent.src.card.SelectMyCardActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText et_id;
    private EditText et_pw;

    private LinearLayout loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_id = findViewById(R.id.login_id);
        et_pw = findViewById(R.id.login_pw);

        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    startActivity(new Intent(getApplicationContext(), SelectMyCardActivity.class));
                }else{
                    Toast.makeText(getApplicationContext(), "id와 pw를 모두 입력해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean validate(){
        if(et_id.getText().toString().length() >0 && et_pw.getText().toString().length()>0)
            return true;
        else
            return false;
    }
}
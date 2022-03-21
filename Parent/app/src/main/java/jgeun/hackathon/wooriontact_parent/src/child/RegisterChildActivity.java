package jgeun.hackathon.wooriontact_parent.src.child;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import jgeun.hackathon.wooriontact_parent.R;

public class RegisterChildActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_child);

        addButton = findViewById(R.id.register_btn_add);
        addButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register_btn_add:
                startActivity(new Intent(this, ChildInfoActivity.class));
                break;
        }
    }
}
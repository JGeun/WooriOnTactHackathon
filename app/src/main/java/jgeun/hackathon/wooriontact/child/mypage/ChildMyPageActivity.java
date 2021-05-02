package jgeun.hackathon.wooriontact.child.mypage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import jgeun.hackathon.wooriontact.R;
import jgeun.hackathon.wooriontact.util.StatusBarUtil;

public class ChildMyPageActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private Context mConText;
    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;

    private HomeFragment homeFragment;
    private CardFragment cardFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_my_page);

        sharedPreferences = this.getSharedPreferences("pay", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("이름", "이름");
        homeFragment = new HomeFragment(name);
        cardFragment = new CardFragment(this, getIntent().getStringExtra("picture"));

        mConText = this;
        setFrag(1);

        bottomNavigationView = findViewById(R.id.child_mypage_bottomNavi);
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_creditCard:
                        setFrag(0);
                        break;
                    case R.id.menu_profile:
                        setFrag(1);
                        break;

                }
                return true;
            }
        });
    }

    public void changeStatusColor(int n){
        if(n == 0){
            StatusBarUtil.setStatusBarColor(this, StatusBarUtil.StatusBarColorType.MAIN_COLOR_STATUS_BAR);
        }else{
            StatusBarUtil.setStatusBarColor(this, StatusBarUtil.StatusBarColorType.WHITE_STATUS_BAR);
        }
    }

    public void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        changeStatusColor(n);
        switch (n) {
            case 0:
                ft.replace(R.id.main_frame, cardFragment);
                ft.commit();
                //creditMenuItem.setIcon(ResourcesCompat.getDrawable(getResources(), R.drawable.profile_user_blue, null));
                //profileMenuItem.setIcon(ResourcesCompat.getDrawable(getResources(), R.drawable.profile_user, null));
                break;
            case 1:
                ft.replace(R.id.main_frame, homeFragment);
                ft.commit();
                //creditMenuItem.setIcon(ResourcesCompat.getDrawable(getResources(), R.drawable.profile_user, null));
                //profileMenuItem.setIcon(ResourcesCompat.getDrawable(getResources(), R.drawable.profile_user_blue, null));
                break;
        }
    }

    public void showCustomToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
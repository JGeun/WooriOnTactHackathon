package jgeun.hackathon.wooriontact_parent.src.mypage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import jgeun.hackathon.wooriontact_parent.R;
import jgeun.hackathon.wooriontact_parent.src.dialog.PaymentDialog;
import jgeun.hackathon.wooriontact_parent.src.signup.SignUpActivity;
import jgeun.hackathon.wooriontact_parent.src.splash.SplashActivity;
import jgeun.hackathon.wooriontact_parent.util.StatusBarUtil;

public class MyPageActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private Context mConText;
    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;

    private ProfileFragment profileFragment;
    private HomeFragment homeFragment;

    private PaymentDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        dialog = new PaymentDialog(this);

        Handler hd = new Handler();
        hd.postDelayed(new CallDialog("설정 금액 초과", "서울특별시 금천구", "홈플러스", "80,000원"), 15000);
        hd.postDelayed(new CallDialog("설정 금액 초과", "서울특별시 성북구", "한성대 서점",  "40,000원"), 40000);
        hd.postDelayed(new CallDialog("제한 품목 결제", "서울특별시 금천구", "(주)아이센스 피시방", "5,000원"), 70000);

        sharedPreferences = this.getSharedPreferences("pay", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("이름", "이름");
        profileFragment = new ProfileFragment(name);

        homeFragment = new HomeFragment(name);

        mConText = this;
        setFrag(1);

        bottomNavigationView = findViewById(R.id.child_mypage_bottomNavi);
        bottomNavigationView.setSelectedItemId(R.id.menu_profile);
        //bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
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

    public void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n) {
            case 0:
                ft.replace(R.id.main_frame, homeFragment);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_frame, profileFragment);
                ft.commit();
                break;
        }
    }


    public class CallDialog implements Runnable {
        private String category;
        private String place;
        private String requestor;
        private String price;

        public CallDialog(String category, String place, String requestor, String price){
            this.category = category;
            this.place = place;
            this.requestor = requestor;
            this.price = price;
        }
        public void run() {
            dialog.callFunction(category, place, requestor, price);
        }
    }

    public void showCustomToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
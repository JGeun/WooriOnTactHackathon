package jgeun.hackathon.wooriontact_parent.src.card;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.accounts.Account;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

import jgeun.hackathon.wooriontact_parent.R;
import jgeun.hackathon.wooriontact_parent.src.card.adapter.CardAdapter;
import jgeun.hackathon.wooriontact_parent.src.card.models.AccData;
import jgeun.hackathon.wooriontact_parent.src.card.models.AccountRequest;
import jgeun.hackathon.wooriontact_parent.src.card.models.AccountResponse;
import jgeun.hackathon.wooriontact_parent.src.card.models.DataBody;
import jgeun.hackathon.wooriontact_parent.src.card.models.DataHeader;
import jgeun.hackathon.wooriontact_parent.src.card.models.ResponseDataBody;
import jgeun.hackathon.wooriontact_parent.src.child.RegisterChildActivity;
import me.relex.circleindicator.CircleIndicator3;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SelectMyCardActivity extends AppCompatActivity implements View.OnClickListener{
    private Activity activity;
    private LinearLayout registerButton;
    private LinearLayout cardButton;

    private ViewPager2 viewpager;
    private CardAdapter cardAdapter;
    private CircleIndicator3 mIndicator;

    private int accTotalCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_my_card);

        activity = this;
        registerButton = findViewById(R.id.select_btn_register);
        registerButton.setOnClickListener(this);

        cardButton = findViewById(R.id.select_cardButton);
        cardButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.select_btn_register:
                startActivity(new Intent(this, RegisterChildActivity.class));
                break;
            case R.id.select_cardButton:
                Log.d("확인", "클릭");
                AccountRequest accountRequest = new AccountRequest(
                        new DataHeader("","","", "","","","",""));

                Call<AccountResponse> call = RetrofitClass.getApiService().postAllAccount(accountRequest);
                call.enqueue(new Callback<AccountResponse>() {
                    @Override
                    public void onResponse(Call<AccountResponse> call, Response<AccountResponse> response) {
                        if(!response.isSuccessful()){
                            Log.e("확인", "연결실패1/"+response.message());
                            return;
                        }else{
                            cardButton.setVisibility(View.GONE);
                            ArrayList<String> accNumList = new ArrayList<>();
                            ArrayList<String> accCategoryList = new ArrayList<>();
                            ResponseDataBody responseDataBody = response.body().getDataBody();
                            int size = responseDataBody.getBodyCount();
                            for(int i=0; i<size; i++){
                                AccData accData = responseDataBody.getAccList().get(i);
                                if(accData.getAccCategory().equals("P")) {
                                    accTotalCount += 1;
                                    accNumList.add(accData.getAccNumber());
                                    accCategoryList.add(accData.getAccName());
                                }

                            }

                            viewpager = findViewById(R.id.select_viewpager);
                            cardAdapter = new CardAdapter((FragmentActivity) activity, accTotalCount, accNumList, accCategoryList);
                            viewpager.setAdapter(cardAdapter);
                            mIndicator = findViewById(R.id.select_indicator);
                            mIndicator.setViewPager(viewpager);
                            viewpager.setVisibility(View.VISIBLE);
                            mIndicator.setVisibility(View.VISIBLE);
                            mIndicator.createIndicators(accTotalCount, 0);
                            viewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
                            //viewpager.setCurrentItem(1000);
                            viewpager.setOffscreenPageLimit(accTotalCount);

                            viewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                                @Override
                                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                                    super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                                    if (positionOffsetPixels == 0) {
                                        viewpager.setCurrentItem(position);
                                    }
                                }

                                @Override
                                public void onPageSelected(int position) {
                                    super.onPageSelected(position);
                                    mIndicator.animatePageSelected(position % accTotalCount);
                                }
                            });
                            cardAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(Call<AccountResponse> call, Throwable t) {
                        Log.e("확인", "연결실패2/"+t.getMessage());
                    }
                });
                break;
        }
    }
}
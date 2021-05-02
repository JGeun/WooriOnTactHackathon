package jgeun.hackathon.wooriontact.child.mypage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.Timer;
import java.util.TimerTask;

import jgeun.hackathon.wooriontact.R;
import jgeun.hackathon.wooriontact.child.signup.ChildSignUpActivity;
import jgeun.hackathon.wooriontact.child.splash.ChildSplashActivity;

public class CardFragment extends Fragment {
    TimerTask timerTask;
    Timer timer = new Timer();

    private Context context;
    private TextView timerText;
    private String imageString;

    private SharedPreferences sharedPreferences;

    public CardFragment(Context context, String imageString) {
        this.imageString = imageString;
        this.context =context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_card, container, false);
        sharedPreferences = getActivity().getSharedPreferences("pay", Context.MODE_PRIVATE);
        timerText = view.findViewById(R.id.card_timer);

        ImageView cardImageView = view.findViewById(R.id.card_childCard);
        Bitmap cardImageBitmap;
        if(imageString != null && !imageString.equals(""))
            cardImageBitmap = StringToBitmap(imageString);
        else
            cardImageBitmap = StringToBitmap(sharedPreferences.getString("picture", ""));

        Matrix rotateMatrix = new Matrix();
        rotateMatrix.postRotate(90); //-360~360

        Bitmap rotateBitmap = Bitmap.createBitmap(cardImageBitmap, 0, 0,
                cardImageBitmap.getWidth(), cardImageBitmap.getHeight(), rotateMatrix, false);


        cardImageView.setImageBitmap(rotateBitmap);
        startTimerTask();

        return view;
    }

    private void startTimerTask()
    {
        stopTimerTask();

        timerTask = new TimerTask()
        {
            int time = 31;

            @Override
            public void run()
            {
                time--;
                timerText.post(new Runnable() {
                    @Override
                    public void run() {
                        timerText.setText(Integer.toString(time));
                        if(time < 1) {
                            time = 31;
                            ((ChildMyPageActivity)context).showCustomToast("인증이 만료되었습니다.");
                        }
                    }
                });
            }
        };
        timer.schedule(timerTask,0 ,1000);
    }

    private void stopTimerTask()
    {
        if(timerTask != null)
        {
            //timerText.setText("31");
            timerTask.cancel();
            timerTask = null;
        }
    }


    public static Bitmap StringToBitmap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
}
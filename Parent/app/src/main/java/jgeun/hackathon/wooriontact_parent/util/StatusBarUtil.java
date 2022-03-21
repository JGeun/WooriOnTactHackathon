package jgeun.hackathon.wooriontact_parent.util;

import android.app.Activity;
import android.os.Build;
import android.view.View;

import androidx.core.content.ContextCompat;

import jgeun.hackathon.wooriontact_parent.R;


public class StatusBarUtil {
    public enum StatusBarColorType {
        // 색 지정
        WHITE_STATUS_BAR(R.color.white),
        MAIN_COLOR_STATUS_BAR(R.color.mainColor),
        DEFAULT_STATUS_BAR(R.color.white);

        private int backgroundColorId;

        StatusBarColorType(int backgroundColorId) {
            this.backgroundColorId = backgroundColorId;
        }

        public int getBackgroundColorId() {
            return backgroundColorId;
        }
    }

    public static void setStatusBarColor(Activity activity, StatusBarColorType colorType) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // 상태바 텍스트 색 지정
            if(colorType.getBackgroundColorId() == R.color.white) {
                // 흰색
                activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            } else {
                // 검은색
                activity.getWindow().getDecorView().setSystemUiVisibility(0);
            }

            // 상태바 배경 색 지정
            activity.getWindow().setStatusBarColor(ContextCompat.getColor(activity, colorType.getBackgroundColorId()));
        }
    }
}

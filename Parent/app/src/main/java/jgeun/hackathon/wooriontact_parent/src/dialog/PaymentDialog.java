package jgeun.hackathon.wooriontact_parent.src.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import jgeun.hackathon.wooriontact_parent.R;
import jgeun.hackathon.wooriontact_parent.src.mypage.MyPageActivity;

public class PaymentDialog implements View.OnClickListener{
    private Dialog dlg;
    private Context context;
    private ImageView okButton;
    private ImageView cancelButton;

    private TextView categoryText;
    private TextView placeText;
    private TextView requestorText;
    private TextView priceText;

    public PaymentDialog(Context context){this.context =context;}
    public void callFunction(String category, String place, String requestor, String price){

        dlg = new Dialog(context);

        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dlg.setContentView(R.layout.dialog_payment);
        dlg.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        okButton = dlg.findViewById(R.id.payment_ok);
        okButton.setOnClickListener(this);
        cancelButton = dlg.findViewById(R.id.payment_cancel);
        cancelButton.setOnClickListener(this);

        categoryText = dlg.findViewById(R.id.payment_category);
        placeText = dlg.findViewById(R.id.payment_place);
        requestorText = dlg.findViewById(R.id.payment_requestor);
        priceText = dlg.findViewById(R.id.payment_price);

        categoryText.setText(category);
        placeText.setText(place);
        requestorText.setText(requestor);
        priceText.setText(price);
        dlg.show();
    }

    public void cancelDialog(){
        dlg.cancel();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.payment_ok:
                ((MyPageActivity)context).showCustomToast("결제 승인되었습니다.");
                dlg.cancel();
                break;
            case R.id.payment_cancel:
                ((MyPageActivity)context).showCustomToast("결제 취소되었습니다.");
                dlg.cancel();
                break;
        }
    }
}

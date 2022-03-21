package jgeun.hackathon.wooriontact_parent.src.card;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import jgeun.hackathon.wooriontact_parent.R;

public class CardFragment extends Fragment {

    private int cardNumber;
    private String accNum;
    private String accCategory;
    public CardFragment(int cardNumber, String accNum, String accCategory){
        this.cardNumber = cardNumber;
        this.accNum = accNum.substring(0,3)+" - " + accNum.substring(3, 8) + " - " + accNum.substring(8, accNum.length());
        this.accCategory = accCategory;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_card, container, false);
        ImageView cardImage = view.findViewById(R.id.card_image);
        TextView accNumText = view.findViewById(R.id.card_accountNumber);
        TextView accCategoryText = view.findViewById(R.id.card_accountCategory);
        accNumText.setText(accNum);
        accCategoryText.setText(accCategory);
        if(cardNumber == 0){
            cardImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.card1, null));
        }else if(cardNumber == 1){
            cardImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.card2, null));
        }else if(cardNumber == 2){
            cardImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.card3, null));
        }else if(cardNumber == 3){
            cardImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.card4, null));
        }

        return view;
    }
}

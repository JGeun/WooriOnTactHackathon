package jgeun.hackathon.wooriontact.child.makeCard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

import jgeun.hackathon.wooriontact.CaptureActivity;
import jgeun.hackathon.wooriontact.R;
import jgeun.hackathon.wooriontact.child.mypage.ChildMyPageActivity;

public class MakeCardActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView firstButton;
    private ImageView firstImage;

    private ImageView secondButton;
    private ImageView secondImage;

    private ImageView thirdButton;
    private ImageView thirdImage;

    private EditText inputEditText;
    private TextView middleText;
    private TextView textCount;

    private ConstraintLayout selectField;
    private ImageView character1;
    private ImageView character2;
    private ImageView character3;
    private ImageView character4;
    private ImageView character5;
    private ImageView character6;
    private ImageView character7;
    private ImageView character8;

    private int selectButtonNumber = 1;
    private int imageNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_card);

        firstButton = findViewById(R.id.card_firstCharacter);
        firstButton.setOnClickListener(this);
        firstImage = findViewById(R.id.card_firstImage);
        firstImage.setOnClickListener(this);

        secondButton = findViewById(R.id.card_secondCharacter);
        secondButton.setOnClickListener(this);
        secondImage = findViewById(R.id.card_secondImage);
        secondImage.setOnClickListener(this);
        thirdButton = findViewById(R.id.card_thirdCharacter);
        thirdButton.setOnClickListener(this);
        thirdImage = findViewById(R.id.card_thirdImage);
        thirdImage.setOnClickListener(this);

        inputEditText = findViewById(R.id.card_inputMiddleText);
        middleText = findViewById(R.id.card_middleText);
        textCount = findViewById(R.id.card_textCount);

        selectField = findViewById(R.id.card_selectField);
        character1 = findViewById(R.id.card_character1);
        character1.setOnClickListener(this);
        character2 = findViewById(R.id.card_character2);
        character2.setOnClickListener(this);
        character3 = findViewById(R.id.card_character3);
        character3.setOnClickListener(this);
        character4 = findViewById(R.id.card_character4);
        character4.setOnClickListener(this);
        character5 = findViewById(R.id.card_character5);
        character5.setOnClickListener(this);
        character6 = findViewById(R.id.card_character6);
        character6.setOnClickListener(this);
        character7 = findViewById(R.id.card_character7);
        character7.setOnClickListener(this);
        character8 = findViewById(R.id.card_character8);
        character8.setOnClickListener(this);

        inputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                middleText.setText(inputEditText.getText());
                textCount.setText(Integer.toString(inputEditText.getText().toString().length()));
            }
        });

        LinearLayout finishButton = findViewById(R.id.child_makecard_btn_finish);
        finishButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.card_firstImage:
                firstImage.setImageDrawable(null);
                firstButton.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_plus, null));
                break;
            case R.id.card_secondImage:
                secondImage.setImageDrawable(null);
                secondButton.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_plus, null));
                break;
            case R.id.card_thirdImage:
                thirdImage.setImageDrawable(null);
                thirdButton.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_plus, null));
                break;
            case R.id.card_firstCharacter:
                setSelectFieldVisibility();
                selectButtonNumber = 1;
                break;
            case R.id.card_secondCharacter:
                setSelectFieldVisibility();
                selectButtonNumber = 2;
                break;
            case R.id.card_thirdCharacter:
                setSelectFieldVisibility();
                selectButtonNumber = 3;
                break;
            case R.id.card_character1:
                imageNumber = 1;
                changeImage();
                break;
            case R.id.card_character2:
                imageNumber = 2;
                changeImage();
                break;
            case R.id.card_character3:
                imageNumber = 3;
                changeImage();
                break;
            case R.id.card_character4:
                imageNumber = 4;
                changeImage();
                break;
            case R.id.card_character5:
                imageNumber = 5;
                changeImage();
                break;
            case R.id.card_character6:
                imageNumber = 6;
                changeImage();
                break;
            case R.id.card_character7:
                imageNumber = 7;
                changeImage();
                break;
            case R.id.card_character8:
                imageNumber = 8;
                changeImage();
                break;
            case R.id.child_makecard_btn_finish:
                Bitmap bitmap = takeScreenshot();
                Bitmap cardBitmap = Bitmap.createBitmap(bitmap, 100, 600, 880, 530);
                Intent intent = new Intent(this, ChildMyPageActivity.class);
                intent.putExtra("picture", BitmapToString(cardBitmap));
                startActivity(intent);
                finish();
                break;
        }
    }

    public void changeImage() {
        if (selectButtonNumber == 1) {
            firstImage.setImageDrawable(getImage());
            firstButton.setImageDrawable(getImage());
        } else if (selectButtonNumber == 2) {
            secondImage.setImageDrawable(getImage());
            secondButton.setImageDrawable(getImage());
        } else {
            thirdImage.setImageDrawable(getImage());
            thirdButton.setImageDrawable(getImage());
        }
        setSelectFieldVisibility();
    }

    public Drawable getImage() {
        switch (imageNumber) {
            case 1:
                return ResourcesCompat.getDrawable(getResources(), R.drawable.hi_blue, null);
            case 2:
                return ResourcesCompat.getDrawable(getResources(), R.drawable.bugi_big, null);
            case 3:
                return ResourcesCompat.getDrawable(getResources(), R.drawable.jji_big, null);
            case 4:
                return ResourcesCompat.getDrawable(getResources(), R.drawable.dak, null);
            case 5:
                return ResourcesCompat.getDrawable(getResources(), R.drawable.boy, null);
            case 6:
                return ResourcesCompat.getDrawable(getResources(), R.drawable.bugi2, null);
            case 7:
                return ResourcesCompat.getDrawable(getResources(), R.drawable.yang, null);
            case 8:
                return ResourcesCompat.getDrawable(getResources(), R.drawable.jji2, null);
            default:
                return ResourcesCompat.getDrawable(getResources(), R.drawable.hi_blue, null);
        }
    }

    public void setSelectFieldVisibility() {
        if (selectField.getVisibility() == View.VISIBLE)
            selectField.setVisibility(View.INVISIBLE);
        else
            selectField.setVisibility(View.VISIBLE);
    }

    public Bitmap takeScreenshot() {
        View rootView = findViewById(android.R.id.content).getRootView();
        rootView.setDrawingCacheEnabled(true);
        return rootView.getDrawingCache();
    }

    public static String BitmapToString(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 70, baos);
        byte[] bytes = baos.toByteArray();
        String temp = Base64.encodeToString(bytes, Base64.DEFAULT);
        return temp;
    }
}
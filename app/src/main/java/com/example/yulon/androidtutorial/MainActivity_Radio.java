package com.example.yulon.androidtutorial;

import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity_Radio extends AppCompatActivity {

    private Button mBtnOK;
    private TextView mTxtR;

    private RadioGroup mRadGrpSex, mRadGrpAge;
    private RadioButton mRadBtnAgeRange1, mRadBtnAgeRange2, mRadBtnAgeRange3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_radio);

        initView();
        mRadGrpSex.setOnCheckedChangeListener(radGrpSexOnCheckedChange);
        mBtnOK.setOnClickListener(btnOKOnClick);
    }

    private  void initView(){
        mBtnOK = (Button)findViewById(R.id.btnOK);
        mTxtR = (TextView)findViewById(R.id.txtSug);
        mRadGrpSex = (RadioGroup)findViewById(R.id.radGrpSex);
        mRadGrpAge = (RadioGroup)findViewById(R.id.radGrpAge);

        mRadBtnAgeRange1 = (RadioButton)findViewById(R.id.radBtnAgeRange1);
        mRadBtnAgeRange2 = (RadioButton)findViewById(R.id.radBtnAgeRange2);
        mRadBtnAgeRange3 = (RadioButton)findViewById(R.id.radBtnAgeRange3);
    }

    private RadioGroup.OnCheckedChangeListener radGrpSexOnCheckedChange = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (radioGroup.getCheckedRadioButtonId()){
                case R.id.radBtnMale:
                    mRadBtnAgeRange1.setText(R.string.male_age_range1);
                    mRadBtnAgeRange2.setText(R.string.male_age_range2);
                    mRadBtnAgeRange3.setText(R.string.male_age_range3);
                    break;
                case R.id.radBtnFeMale:
                    mRadBtnAgeRange1.setText(R.string.female_age_range1);
                    mRadBtnAgeRange2.setText(R.string.female_age_range2);
                    mRadBtnAgeRange3.setText(R.string.female_age_range3);
                    break;
            }
        }
    };

    private View.OnClickListener btnOKOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String strSug = getString(R.string.suggestion);

            switch (mRadGrpAge.getCheckedRadioButtonId()){
                case R.id.radBtnAgeRange1:
                    strSug += getString(R.string.sug_not_hurry);
                    break;
                case R.id.radBtnAgeRange2:
                    strSug += getString(R.string.sug_find_couple);
                    break;
                case R.id.radBtnAgeRange3:
                    strSug += getString(R.string.sug_get_married);
                    break;
            }

            mTxtR.setText(strSug);
        }
    };
}

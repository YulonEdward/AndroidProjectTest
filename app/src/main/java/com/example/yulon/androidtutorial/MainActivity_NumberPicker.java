package com.example.yulon.androidtutorial;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity_NumberPicker extends AppCompatActivity{

    private TextView mTxtR ,mTxtAge;
    private Spinner mSpnSex;
    private Button mBtnOK;
    private NumberPicker mNumberPickerSex;
    private String mStrSex;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_numberpicker);

        initView();
        mSpnSex.setOnItemSelectedListener(spnSexOnItemSelected);
        mNumberPickerSex.setMaxValue(200);
        mNumberPickerSex.setMinValue(0);
        mNumberPickerSex.setValue(25);
        mTxtAge.setText(String.valueOf(mNumberPickerSex.getValue()));
        mNumberPickerSex.setOnValueChangedListener(numberPickerAgeOnValueChange);
        mBtnOK.setOnClickListener(btnOKOnClick);
    }

    private void initView(){
        mTxtR = (TextView)findViewById(R.id.txtSug);
        mTxtAge = (TextView)findViewById(R.id.txtAge);
        mSpnSex = (Spinner)findViewById(R.id.spnSex);
        mBtnOK = (Button)findViewById(R.id.btnOK);
        mNumberPickerSex = (NumberPicker)findViewById(R.id.numberPickerAge);
    }

    private View.OnClickListener btnOKOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int iAge = mNumberPickerSex.getValue();

            String strSug = getString(R.string.suggestion);
            if(mStrSex.equals(getString(R.string.sex_male))){
                if(iAge < 28){
                    strSug += getString(R.string.sug_not_hurry);
                }else if(iAge > 33){
                    strSug += getString(R.string.sug_get_married);
                }else{
                    strSug += getString(R.string.sug_find_couple);
                }
            }else{
                if(iAge < 25){
                    strSug += getString(R.string.sug_not_hurry);
                }else if(iAge > 30){
                    strSug += getString(R.string.sug_get_married);
                }else{
                    strSug += getString(R.string.sug_find_couple);
                }
            }

            mTxtR.setText(strSug);
        }
    };

    private AdapterView.OnItemSelectedListener spnSexOnItemSelected = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            mStrSex = adapterView.getSelectedItem().toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    private NumberPicker.OnValueChangeListener numberPickerAgeOnValueChange = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker numberPicker, int i, int i1) {
            mTxtAge.setText(String.valueOf(i1));
        }
    };

}

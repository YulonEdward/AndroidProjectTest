package com.example.yulon.androidtutorial;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_checkbox extends AppCompatActivity{

    private CheckBox mChkBoxMusic, mChkBoxSing, mChkBoxDance, mChkBoxTravel, mChkBoxreading, mChkBoxWriting, mChkBoxClimbing,
            mChkBoxSwim, mChkBoxExercise, mChkBoxFitness, mChkBoxPhoto, mChkBoxPainting, mChkBoxEating;

    private Button mBtnOK;
    private TextView mTxtHobby;
    private List<String> mDataList = new ArrayList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_checkbox);

        initView();
        mBtnOK.setOnClickListener(btnOKOnClick);
    }

    private void initView(){
        mBtnOK = (Button)findViewById(R.id.btnOK);
        mTxtHobby = (TextView)findViewById(R.id.txtHobby);

        mChkBoxClimbing = (CheckBox)findViewById(R.id.checkBoxClimbing);
        mChkBoxMusic = (CheckBox)findViewById(R.id.checkBoxMusic);
        mChkBoxSing = (CheckBox)findViewById(R.id.checkBoxSing);
        mChkBoxDance = (CheckBox)findViewById(R.id.checkBoxDance);
        mChkBoxTravel = (CheckBox)findViewById(R.id.checkBoxTravel);
        mChkBoxreading = (CheckBox)findViewById(R.id.checkBoxReading);
        mChkBoxWriting = (CheckBox)findViewById(R.id.checkBoxWriting);
        mChkBoxSwim = (CheckBox)findViewById(R.id.checkBoxSwim);
        mChkBoxExercise = (CheckBox)findViewById(R.id.checkBoxExercise);
        mChkBoxFitness = (CheckBox)findViewById(R.id.checkBoxFitness);
        mChkBoxPhoto = (CheckBox)findViewById(R.id.checkBoxPhoto);
        mChkBoxPainting = (CheckBox)findViewById(R.id.checkBoxPainting);
        mChkBoxEating = (CheckBox)findViewById(R.id.checkBoxEating);
    }

    private View.OnClickListener btnOKOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String s = getString(R.string.your_hobby);

            if(mChkBoxClimbing.isChecked()){
                s += mChkBoxClimbing.getText().toString();
                AddStringData(mChkBoxClimbing.getText().toString());
            }
            if(mChkBoxDance.isChecked()){
                s += mChkBoxDance.getText().toString();
                AddStringData(mChkBoxDance.getText().toString());
            }
            if(mChkBoxEating.isChecked()){
                s += mChkBoxEating.getText().toString();
                AddStringData(mChkBoxEating.getText().toString());
            }
            if(mChkBoxExercise.isChecked()){
                s += mChkBoxExercise.getText().toString();
                AddStringData(mChkBoxExercise.getText().toString());
            }
            if(mChkBoxFitness.isChecked()){
                s += mChkBoxFitness.getText().toString();
                AddStringData(mChkBoxFitness.getText().toString());
            }
            if(mChkBoxMusic.isChecked()){
                s += mChkBoxMusic.getText().toString();
                AddStringData(mChkBoxMusic.getText().toString());
            }
            if(mChkBoxPainting.isChecked()){
                s += mChkBoxPainting.getText().toString();
                AddStringData(mChkBoxPainting.getText().toString());
            }
            if(mChkBoxPhoto.isChecked()){
                s += mChkBoxPhoto.getText().toString();
                AddStringData(mChkBoxPhoto.getText().toString());
            }
            if(mChkBoxreading.isChecked()){
                s += mChkBoxreading.getText().toString();
                AddStringData(mChkBoxreading.getText().toString());
            }
            if(mChkBoxSing.isChecked()){
                s += mChkBoxSing.getText().toString();
                AddStringData(mChkBoxSing.getText().toString());
            }
            if(mChkBoxSwim.isChecked()){
                s += mChkBoxSwim.getText().toString();
                AddStringData(mChkBoxSwim.getText().toString());
            }
            if(mChkBoxTravel.isChecked()){
                s += mChkBoxTravel.getText().toString();
                AddStringData(mChkBoxTravel.getText().toString());
            }
            if(mChkBoxWriting.isChecked()){
                s += mChkBoxWriting.getText().toString();
                AddStringData(mChkBoxWriting.getText().toString());
            }

//            mTxtHobby.setText(s);
            showData();
        }
    };

    private void AddStringData(String strData){
        mDataList.add(strData);
    }

    private void showData(){
        String str = getString(R.string.your_hobby);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < mDataList.size(); i++){
            if(sb.length() > 0){
                sb.append("、");
            }
            sb.append(mDataList.get(i));
        }

        str += sb.toString();
        mTxtHobby.setText(str);
        mDataList.clear();
    }
}

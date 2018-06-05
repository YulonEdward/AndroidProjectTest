package com.example.yulon.androidtutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mTxtSug;
//    EditText mEdtSex;
    EditText mEdtAge;
    Button btnOK;
    private String msSex;
    private Spinner mSpanSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        btnOK.setOnClickListener(btnClickListener);
        mSpanSex.setOnItemSelectedListener(spnSexonItemSelected);
    }

    private void initView(){
        mTxtSug = (TextView)findViewById(R.id.txtSug);
        mEdtAge = (EditText)findViewById(R.id.edtAge);
//        mEdtSex = (EditText)findViewById(R.id.edtSex);
        btnOK = (Button)findViewById(R.id.btnOK);
        mSpanSex = (Spinner)findViewById(R.id.spnSex);

    }

    private AdapterView.OnItemSelectedListener spnSexonItemSelected = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            msSex = adapterView.getSelectedItem().toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    private View.OnClickListener btnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
//            String strSex = mEdtSex.getText().toString();
            String strSug = getString(R.string.suggestion);

            if(msSex != null && !mEdtAge.getText().toString().matches("")){
                int iAge = Integer.parseInt(mEdtAge.getText().toString());

                if(msSex.equals(getString(R.string.sex_male))){
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

                mTxtSug.setText(strSug);
            }
        }
    };
}

package com.brandent.kalkylator_grupparbete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    boolean isTwoFieldShowed = true;

    EditText input1;
    EditText input2;

    String inputStr1 = "";
    String inputStr2 = "";
    String tempStr = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         input1 = findViewById(R.id.input1);
         input2 = findViewById(R.id.input2);
    }

    public void cylinderBtnClicked(View view) {
        changeFieldsVisibility(false);
    }

    public void plusBtnClicked(View view) {
        changeFieldsVisibility(true);
    }

    private void changeFieldsVisibility(boolean showTwoField){
        if(showTwoField){

            input1.setVisibility(View.VISIBLE);
            isTwoFieldShowed = true;
            input2.setText(tempStr);
        } else {
            tempStr = input2.getText().toString();
            input2.setText(input1.getText().toString());
            input1.setVisibility(View.GONE);

            isTwoFieldShowed = false;
        }

    }


}
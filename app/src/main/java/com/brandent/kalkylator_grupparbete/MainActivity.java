package com.brandent.kalkylator_grupparbete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double resultAsDouble;
    double input1AsDouble;
    double input2AsDouble;
    EditText input1;
    EditText input2;
    TextView resultText;

    boolean isTwoFieldShowed = true;
    String inputStr1 = "";
    String inputStr2 = "";
    String tempStr = "";
    String currentOperation = "plus";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        resultText =findViewById(R.id.display_result_tw);

        Button plusButton = findViewById(R.id.button_plus);


        Button minusButton =findViewById(R.id.button_minus);
//        minusButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getInput1();
//                getInput2();
//                subtraction();
//            }
//        });
//
//        Button divideButton =findViewById(R.id.button_divide);
//        divideButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getInput1();
//                getInput2();
//                division();
//            }
//        });
//
//        Button squareRootButton =findViewById(R.id.button_square_root);
//        squareRootButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getInput1();
//                squareRoot();
//            }
//        });
//
//        Button percentButton =findViewById(R.id.button_procent);
//        percentButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getInput1();
//                getInput2();
//                percent();
//            }
//        });
//
//        Button multiplicationButton =findViewById(R.id.multiply);
//        multiplicationButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getInput1();
//                getInput2();
//                multiplication();
//            }
//        });
//
//
//        ImageButton pythagorasButton =findViewById(R.id.button_pythager);
//        pythagorasButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getInput1();
//                getInput2();
//                pythagoras();
//            }
//        });
//        //Ska vara cylinder volym
//        ImageButton CylinderVolumeButton =findViewById(R.id.button_cylinder_area);
//        divideButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getInput1();
//                getInput2();
//                cylinderVolume();
//            }
//        });
//        Button circleAreaButton =findViewById(R.id.button_circle_area);
//        circleAreaButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getInput1();
//                getInput2();
//                circleArea();
//            }
//        });
//
//
//        Button resultButton = findViewById(R.id.button_result);
//        resultButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                setResult();
//
//            }
//        });

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

    //hämtar input från Edittext och gör om till Double
    public double getInput1(){
        String input1AsString = input1.getText().toString();
        input1AsDouble = Double.parseDouble(input1AsString);
        return input1AsDouble;

    }

    public double getInput2(){
        String input2AsString = input2.getText().toString();
        input2AsDouble = Double.parseDouble(input2AsString);
        return input2AsDouble;

    }

    // Gör om svar till en sträng och visar det i resultText.
    public void setResult(){

        String resultAsString = Double.toString(resultAsDouble);
        resultText.setText(resultAsString);
        resultText.setVisibility(View.VISIBLE);
    }

    public double addition() {

        resultAsDouble = input1AsDouble + input2AsDouble;
        return resultAsDouble;

    }

    public void subtraction() {
        resultAsDouble = input1AsDouble - input2AsDouble;
    }

    public void multiplication() {
        resultAsDouble = input1AsDouble * input2AsDouble;
    }

    public void division() {
        resultAsDouble = input1AsDouble/input2AsDouble;
    }
    //
    public void percent() {
        resultAsDouble = (input1AsDouble/100) * input2AsDouble;
    }
    // Tar roten ur på input1 bara
    public void squareRoot() {
        resultAsDouble = Math.sqrt(input1AsDouble);
    }

    public void pythagoras() {
        resultAsDouble = Math.pow(input1AsDouble,2) +Math.pow(input2AsDouble,2);
    }
    //vi räknar med input1 som radie
    public void circleArea() {
        resultAsDouble = Math.pow( input1AsDouble,2) * Math.PI;
    }
    // vi räknar med input1 som radie och input 2 som höjd
    public void cylinderVolume() {
        resultAsDouble = Math.pow( input1AsDouble,2) * Math.PI *input2AsDouble;
    }

    public void clearBtnClicked(View view) {

    }

    public void plusBtnClicked(View view) {

        changeFieldsVisibility(true);
    }

    public void minusBtnClicked(View view) {
    }

    public void divideBtnClicked(View view) {
    }

    public void rootBtnClicked(View view) {
    }

    public void percentBtnClicked(View view) {
    }

    public void multiplyBtnClicked(View view) {
    }

    public void pyfagorBtnClicked(View view) {
    }

    public void cylinderBtnClicked(View view) {
    }

    public void circleBtnClicked(View view) {
        changeFieldsVisibility(false);
    }

    public void resultBtnClicked(View view) {
    }
}
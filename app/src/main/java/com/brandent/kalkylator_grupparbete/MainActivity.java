package com.brandent.kalkylator_grupparbete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
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
    String currentOperation = "+";

    ImageView mathMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        resultText =findViewById(R.id.display_result_tw);
        mathMode = findViewById(R.id.math_mode);
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

    private void setImage(String imageName) {

        int id = getResources().getIdentifier(imageName,"drawable",getPackageName());
        mathMode.setImageResource(id);

    }

    //hämtar input från Edittext och gör om till Double
    public String checkInput(EditText input){
        String inputStr = input.getText().toString();

        if(isNumeric(inputStr)) {
            return inputStr;
        } else {
            return "ERROR";
        }
    }


    // Gör om svar till en sträng och visar det i resultText.
    public void setResult(double result){
        DecimalFormat df = new DecimalFormat("#.00");

        String resultAsString = df.format(result);

        resultText.setVisibility(View.VISIBLE);
        resultText.setText(resultAsString);
    }

    //Clear input field
    public void clearBtnClicked(View view) {
        input1.setText("");
        input2.setText("");
    }

    public void plusBtnClicked(View view) {
        currentOperation = "+";
        input1.setHint("value 1");
        input2.setHint("value 2");
        changeFieldsVisibility(true);
        setImage("plus");
    }

    public void minusBtnClicked(View view) {
        currentOperation = "-";
        input1.setHint("value 1");
        input2.setHint("value 2");
        changeFieldsVisibility(true);
        setImage("minus");
    }

    public void divideBtnClicked(View view) {
        currentOperation = "/";
        input1.setHint("value 1");
        input2.setHint("value 2");
        changeFieldsVisibility(true);
        setImage("division");
    }

    public void rootBtnClicked(View view) {
        currentOperation = "√";
        changeFieldsVisibility(false);
        input1.setHint("");
        input2.setHint("Value");
        setImage("sqr_root");
    }

    public void percentBtnClicked(View view) {
        currentOperation = "%";
        changeFieldsVisibility(true);
        input1.setHint("%");
        input2.setHint("Value");
        setImage("procent_sign");
    }

    public void multiplyBtnClicked(View view) {
        currentOperation = "*";
        input1.setHint("value 1");
        input2.setHint("value 2");
        changeFieldsVisibility(true);
        setImage("multiply");
    }

    public void pyfagorBtnClicked(View view) {
        currentOperation = "pythagoras";
        input1.setHint("value a");
        input2.setHint("value b");
        changeFieldsVisibility(true);
        setImage("a2b2");

    }

            //Ska vara cylinder volym
    public void cylinderBtnClicked(View view) {
        currentOperation = "cylinder";
        changeFieldsVisibility(true);
        input1.setHint("Radie");
        input2.setHint("Height");
        setImage("cylinder");
    }

    public void circleBtnClicked(View view) {
        currentOperation = "circle";
        input2.setHint("Radie");
        changeFieldsVisibility(false);
        setImage("sphere");
    }

    public void resultBtnClicked(View view) {
        if( checkInput(input1) != "ERROR" && checkInput(input2) != "ERROR" && isTwoFieldShowed) {
            double input1AsDouble = Double.parseDouble(input1.getText().toString());
            double input2AsDouble = Double.parseDouble(input2.getText().toString());
            switchOperation(input1AsDouble, input2AsDouble);
        } else if(checkInput(input2) != "ERROR" && !isTwoFieldShowed) {
            double input2AsDouble = Double.parseDouble(input2.getText().toString());
            switchOperation(0, input2AsDouble);
        } else {
            resultText.setText("ERROR");
        }
    }

    private void switchOperation(double in1, double in2) {
        CalcMath calc = new CalcMath(in1, in2);

        double result = 0;

        switch (currentOperation) {
            case "+":
                result = calc.addition();
                break;

            case "-":
                result = calc.subtraction();
                break;

            case "/":
                result = calc.division();
                break;

            case "%":
                result = calc.percent();
                break;

            case  "*":
                result = calc.multiplication();
                break;

            case "pythagoras":
                result = calc.pythagoras();
                break;

            case "√":
                result = calc.squareRoot();
                break;

            case "cylinder":
                result = calc.cylinderVolume();
                break;

            case "circle":
                result = calc.circleArea();
                break;

            default:
                Toast toast=Toast.makeText(getApplicationContext(),"Something went wrong with current operation." ,Toast.LENGTH_SHORT);
                toast.show();
        }
        setResult(result);
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
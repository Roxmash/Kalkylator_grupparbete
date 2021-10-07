package com.brandent.kalkylator_grupparbete;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText input1;
    EditText input2;
    TextView resultText;
    ImageButton buttonPlus;
    ImageButton buttonMinus;
    ImageButton buttonDivide;
    ImageButton buttonRoot;
    ImageButton buttonPercent;
    ImageButton buttonMultiply;
    ImageButton buttonPythagorean;
    ImageButton buttonCylinderVolume;
    ImageButton buttonCircleArea;


    boolean isTwoFieldShowed = true;

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
        buttonPlus = findViewById(R.id.button_plus);
        buttonMinus = findViewById(R.id.button_minus);
        buttonDivide = findViewById(R.id.button_divide);
        buttonRoot = findViewById(R.id.button_square_root);
        buttonPercent = findViewById(R.id.button_procent);
        buttonMultiply = findViewById(R.id.button_multiply);
        buttonPythagorean = findViewById(R.id.button_pythager);
        buttonCylinderVolume = findViewById(R.id.button_cylinder_volume);
        buttonCircleArea = findViewById(R.id.button_circle_area);


    }

    private void changeFieldsVisibility(boolean showTwoField){
        if(showTwoField){
            input1.setVisibility(View.VISIBLE);
            isTwoFieldShowed = true;

        }
            else {
            input2.setText(input1.getText().toString());
            input1.setVisibility(View.GONE);
            isTwoFieldShowed = false;
        }

    }

    private void setImage(String imageName) {

        int id = getResources().getIdentifier(imageName,"drawable",getPackageName());

        mathMode.setImageResource(id);


    }
// Animations metoder, om "mode" knappen flyttar på sig, utför animation, annars gör inget.
    private void animateButton() {
        if (isTwoFieldShowed) {

            mathMode.animate().translationX(0).start();

        } else
            mathMode.animate().translationX(-25f).start();
    }

    private void animateButtonLeft() {
        mathMode.animate().translationX(50f).start();
    }

    private void changeBackgroundColour() {
        ImageButton.
        buttonPlus.setBackgroundTintList(Color.getResources().getColorStateList(R.color.button_pressed_colour));

        view.background.setTin
                Ima

    }

    //hämtar input från Edittext och gör om till Double
    public String checkInput(EditText input){
        String inputStr = input.getText().toString();

        if(isNumeric(inputStr)) {
            return inputStr;
        } else {
            return error;
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
        animateButton();

        }

    public void minusBtnClicked(View view) {
        currentOperation = "-";
        input1.setHint("value 1");
        input2.setHint("value 2");
        changeFieldsVisibility(true);
        setImage("minus");
        animateButton();
    }

    public void divideBtnClicked(View view) {
        currentOperation = "/";
        input1.setHint("value 1");
        input2.setHint("value 2");
        changeFieldsVisibility(true);
        setImage("division");
        animateButton();
    }

    public void rootBtnClicked(View view) {
        currentOperation = "√";
        changeFieldsVisibility(false);
        input1.setHint("");
        input2.setHint("Value");
        setImage("sqr_root");
        animateButtonLeft();
    }


    public void percentBtnClicked(View view) {
        currentOperation = "%";
        changeFieldsVisibility(true);
        input1.setHint("%");
        input2.setHint("Value");
        setImage("procent_sign");
        animateButton();
    }

    public void multiplyBtnClicked(View view) {
        currentOperation = "*";
        input1.setHint("value 1");
        input2.setHint("value 2");
        changeFieldsVisibility(true);
        setImage("multiply");
        animateButton();
    }

    public void pyfagorBtnClicked(View view) {
        currentOperation = "pythagoras";
        input1.setHint("value a");
        input2.setHint("value b");
        changeFieldsVisibility(true);
        setImage("a2b2");
        animateButton();

    }

            //Ska vara cylinder volym
    public void cylinderBtnClicked(View view) {
        currentOperation = "cylinder";
        changeFieldsVisibility(true);
        input1.setHint("Radie");
        input2.setHint("Height");
        setImage("cylinder");
        animateButton();
    }

    public void circleBtnClicked(View view) {
        currentOperation = "circle";
        input2.setHint("Radie");
        changeFieldsVisibility(false);
        setImage("sphere");
        animateButtonLeft();
        }

    String error = "ERROR";
    public void resultBtnClicked(View view) {
        if(!checkInput(input1).equals(error) && !checkInput(input2).equals(error) && isTwoFieldShowed) {
            double input1AsDouble = Double.parseDouble(input1.getText().toString());
            double input2AsDouble = Double.parseDouble(input2.getText().toString());
            switchOperation(input1AsDouble, input2AsDouble);
        } else if(!checkInput(input2).equals(error) && !isTwoFieldShowed) {
            double input2AsDouble = Double.parseDouble(input2.getText().toString());
            switchOperation(0, input2AsDouble);
        } else {
            resultText.setText(error);
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
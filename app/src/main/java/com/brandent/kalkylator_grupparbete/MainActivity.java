package com.brandent.kalkylator_grupparbete;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
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

    boolean isTwoFieldShowed = true;

    String currentOperation = "+";
    static final String ERROR = "ERROR";

    String tempInputStr = "";

    ImageView mathMode;
    ImageButton buttonClear;
    ImageButton buttonPlus;
    ImageButton buttonMinus;
    ImageButton buttonDivide;
    ImageButton buttonRoot;
    ImageButton buttonPercent;
    ImageButton buttonMultiply;
    ImageButton buttonPythagorean;
    ImageButton buttonCylinderVolume;
    ImageButton buttonCircleArea;
    ImageButton buttonResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        mathMode = findViewById(R.id.math_mode);
        resultText = findViewById(R.id.display_result_tw);
        buttonPlus = findViewById(R.id.button_plus);
        buttonRoot = findViewById(R.id.button_square_root);
        buttonClear = findViewById(R.id.button_erase);
        buttonMinus = findViewById(R.id.button_minus);
        buttonDivide = findViewById(R.id.button_divide);
        buttonResult = findViewById(R.id.button_result);
        buttonPercent = findViewById(R.id.button_percent);
        buttonMultiply = findViewById(R.id.button_multiply);
        buttonCircleArea = findViewById(R.id.button_circle_area);
        buttonPythagorean = findViewById(R.id.button_pythager);
        buttonCylinderVolume = findViewById(R.id.button_cylinder_volume);

    }


    @SuppressLint("UseCompatLoadingForColorStateLists")
    public void tintButton(ImageButton button){

        ColorStateList tint = getResources().getColorStateList(R.color.button_colour);

         buttonPlus.setBackgroundTintList(tint);
         buttonClear.setBackgroundTintList(tint);
         buttonMinus.setBackgroundTintList(tint);
         buttonDivide.setBackgroundTintList(tint);
         buttonRoot.setBackgroundTintList(tint);
         buttonPercent.setBackgroundTintList(tint);
         buttonMultiply.setBackgroundTintList(tint);
         buttonPythagorean.setBackgroundTintList(tint);
         buttonCylinderVolume.setBackgroundTintList(tint);
         buttonCircleArea.setBackgroundTintList(tint);
         buttonResult.setBackgroundTintList(tint);
         button.setBackgroundTintList(getResources().getColorStateList(R.color.pressed_button));
    }


    private void changeFieldsVisibility(boolean showTwoField){

        if(showTwoField && !isTwoFieldShowed){
            input1.setVisibility(View.VISIBLE);
            isTwoFieldShowed = true;
            input2.setText(tempInputStr);
        }
        else if(!showTwoField && isTwoFieldShowed){
            tempInputStr = input2.getText().toString();
            input2.setText(input1.getText().toString());
            input1.setVisibility(View.GONE);
            isTwoFieldShowed = false;
        }

    }

    // Ändrar till rätt bild brevid inmatningsfälten för respektive matteoperation.

    private void setImage(String imageName) {
        int id = getResources().getIdentifier(imageName,"drawable",getPackageName());
        mathMode.setImageResource(id);
    }

// Animations metoder, om "mode" knappen flyttar på sig, utför animation, annars gör inget.
    private void animateButton() {
        if (isTwoFieldShowed) {
            mathMode.animate()
                    .setDuration(500)
                    .translationX(0)
                    .start();
        } else
            mathMode.animate().translationX(-25f).start();
    }

    private void animateButtonLeft() {
        mathMode.animate()
                .translationX(50f)
                .setDuration(500)
                .start();
    }

    // Gör om svar till en sträng med två decimaler och visar det i resultText.
    public void setResult(double result){
        DecimalFormat df = new DecimalFormat("#.00");
        String resultAsString = df.format(result);
        resultText.setText(resultAsString);

    }

    //Clear input field
    public void clearBtnClicked(View view) {
        tintButton(buttonClear);
        input1.setText("");
        input2.setText("");
        resultText.setText("");
        tempInputStr = "";
    }

    public void plusBtnClicked(View view) {
        tintButton(buttonPlus);
        currentOperation = "+";
        input1.setHint("Value 1");
        input2.setHint("Value 2");
        changeFieldsVisibility(true);
        setImage("plus");
        animateButton();
        }

    public void minusBtnClicked(View view) {
        tintButton(buttonMinus);
        currentOperation = "-";
        input1.setHint("Value 1");
        input2.setHint("Value 2");
        changeFieldsVisibility(true);
        setImage("minus");
        animateButton();
    }

    public void divideBtnClicked(View view) {
        tintButton(buttonDivide);
        currentOperation = "/";
        input1.setHint("Value 1");
        input2.setHint("Value 2");
        changeFieldsVisibility(true);
        setImage("division");
        animateButton();
    }

    public void rootBtnClicked(View view) {
        tintButton(buttonRoot);
        currentOperation = "√";
        changeFieldsVisibility(false);
        input1.setHint("");
        input2.setHint("Value");
        setImage("sqr_root");
        animateButtonLeft();
    }


    public void percentBtnClicked(View view) {
        tintButton(buttonPercent);
        currentOperation = "%";
        changeFieldsVisibility(true);
        input1.setHint("%");
        input2.setHint("Value");
        setImage("procent_sign");
        animateButton();
    }

    public void multiplyBtnClicked(View view) {
        tintButton(buttonMultiply);
        currentOperation = "*";
        input1.setHint("Value 1");
        input2.setHint("Value 2");
        changeFieldsVisibility(true);
        setImage("multiply");
        animateButton();
    }

    public void pythagorBtnClicked(View view) {
        tintButton(buttonPythagorean);
        currentOperation = "pythagoras";
        input1.setHint("Value A");
        input2.setHint("Value B");
        changeFieldsVisibility(true);
        setImage("a2b2");
        animateButton();

    }

    public void cylinderBtnClicked(View view) {
        tintButton(buttonCylinderVolume);
        currentOperation = "cylinder";
        changeFieldsVisibility(true);
        input1.setHint("Radie");
        input2.setHint("Height");
        setImage("cylinder");
        animateButton();
    }

    public void circleBtnClicked(View view) {
        tintButton(buttonCircleArea);
        currentOperation = "circle";
        input2.setHint("Radie");
        changeFieldsVisibility(false);
        setImage("sphere");
        animateButtonLeft();
        }

  /* Kollar om det är ett siffervärde i inmatningsfälten.
     Om det är ett siffervärde använder den det annars Error.
     Om det inte är Error och fälten är ifyllda med  så tar vi in inputsen och gör om
     till doubles för sen skicka in i mattefunktionerna.
*/

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public String checkInput(EditText input){
        String inputStr = input.getText().toString();

        if(isNumeric(inputStr)) {
            return inputStr;
        } else {
            return ERROR;
        }
    }


    public void resultBtnClicked(View view) {
            tintButton(buttonResult);

            CalcMath calc;
            if (!checkInput(input1).equals(ERROR)  && !checkInput(input2).equals(ERROR)  && isTwoFieldShowed) {
                double input1AsDouble = Double.parseDouble(input1.getText().toString());
                double input2AsDouble = Double.parseDouble(input2.getText().toString());
                calc = new CalcMath(input1AsDouble, input2AsDouble);
                switchOperation(calc);
            } else if (!checkInput(input2).equals(ERROR) && !isTwoFieldShowed) {
                double input2AsDouble = Double.parseDouble(input2.getText().toString());
                calc = new CalcMath(0, input2AsDouble);
                switchOperation(calc);
            } else {
                showError();
            }
    }

    private void showError(){
        resultText.setText(ERROR);
    }

    private void switchOperation(CalcMath calc) {

        boolean isError = false;
        switch (currentOperation) {
            case "+":
                calc.addition();
                break;

            case "-":
                calc.subtraction();
                break;

            case "/":
                if(calc.input2 == 0) {
                    isError = true;
                } else {
                    calc.division();
                }
                break;

            case "%":
                calc.percent();
                break;

            case  "*":
                calc.multiplication();
                break;

            case "pythagoras":
                if(calc.input1 < 0 || calc.input2 < 0) {
                    isError = true;
                } else {
                    calc.pythagoras();
                }
                break;

            case "√":
                if(calc.input2 < 0) {
                    isError = true;
                } else{
                    calc.squareRoot();
                }
                break;

            case "cylinder":
                if(calc.input1 < 0 || calc.input2 < 0) {
                    isError = true;
                } else {
                    calc.cylinderVolume();
                }
                break;

            case "circle":
                if(calc.input2 < 0) {
                    isError = true;
                } else {
                    calc.circleArea();
                }
                break;
            default:
                Toast toast=Toast.makeText(getApplicationContext(),"Something went wrong with current operation." ,Toast.LENGTH_SHORT);
                toast.show();
        }

        if(isError) {
            showError();
        } else {
            setResult(calc.result);
        }
    }
}
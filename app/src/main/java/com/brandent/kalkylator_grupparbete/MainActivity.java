package com.brandent.kalkylator_grupparbete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.system.ErrnoException;
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
    String currentOperation = "+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        resultText =findViewById(R.id.display_result_tw);

//        Button plusButton = findViewById(R.id.button_plus);
//        Button minusButton =findViewById(R.id.button_minus);


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
    public double getInput(EditText input){
        String input1AsString = input.getText().toString();

        double input1AsDouble = Double.parseDouble(input1AsString);

//        try {
//            double input1AsDouble = Double.parseDouble(input1AsString);
//        } catch (Exception e){
//            Toast toast=Toast.makeText(getApplicationContext(),"Error for first input" + e,Toast.LENGTH_SHORT);
//            toast.show();
//        }
        return input1AsDouble;
    }
    // Gör om svar till en sträng och visar det i resultText.
    public void setResult(){
        DecimalFormat df = new DecimalFormat("#.00");

        String resultAsString = df.format(resultAsDouble);

        resultText.setVisibility(View.VISIBLE);
    }

    //Clear input field
    public void clearBtnClicked(View view) {
        input1.setText("");
        input2.setText("");
    }

    public void plusBtnClicked(View view) {
        currentOperation = "+";
        changeFieldsVisibility(true);
    }

    public void minusBtnClicked(View view) {
        currentOperation = "-";
        changeFieldsVisibility(true);
    }

    public void divideBtnClicked(View view) {
        currentOperation = "/";
        changeFieldsVisibility(true);
    }

    public void rootBtnClicked(View view) {
        currentOperation = "√";
        changeFieldsVisibility(false);
        input1.setHint("%");
        input2.setHint("Value");

    }

    public void percentBtnClicked(View view) {
        currentOperation = "%";
        changeFieldsVisibility(true);
        input1.setHint("%");
        input2.setHint("Value");
    }

    public void multiplyBtnClicked(View view) {
        currentOperation = "*";
        changeFieldsVisibility(true);
    }

    public void pyfagorBtnClicked(View view) {
        currentOperation = "pythagoras";
        changeFieldsVisibility(true);
    }

    public void cylinderBtnClicked(View view) {
        currentOperation = "cylinder";
        changeFieldsVisibility(true);
        input1.setHint("Radie");
        input2.setHint("Height");
    }

    public void circleBtnClicked(View view) {
        currentOperation = "circle";
        changeFieldsVisibility(false);
    }

    public void resultBtnClicked(View view) {

         input1AsDouble = getInput(input1);
         input2AsDouble = getInput(input2);

        switch (currentOperation) {
            case "+":
                addition();
                break;

            case "-":
                subtraction();
                break;

            case "/":
                division();
                break;

            case "%":
                percent();
                break;

            case  "*":
                multiplication();
                break;

            case "pythagoras":
                pythagoras();
                break;

            case "√":
                squareRoot();
                break;

            case "cylinder":
                cylinderVolume();
                break;

            case "circle":
                circleArea();
                break;

            default:
                Toast toast=Toast.makeText(getApplicationContext(),"Something went wrong with current operation." ,Toast.LENGTH_SHORT);
                toast.show();
        }
        setResult();
    }


    public void addition() {
        resultAsDouble = input1AsDouble + input2AsDouble;
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
        resultAsDouble = Math.pow(input1AsDouble, 2) * Math.PI * input2AsDouble;
    }

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
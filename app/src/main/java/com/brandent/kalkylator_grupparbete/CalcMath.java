package com.brandent.kalkylator_grupparbete;

public class CalcMath {

    public double input1;
    public double input2;
    public double result;

    public CalcMath(double input1, double input2){

        this.input1 = input1;
        this.input2 = input2;
    }

    public void addition() { result = input1 + input2; }
    public void subtraction() {
        result = input1 - input2;
    }

    public void multiplication() {
        result = input1 * input2;
    }

    public void division() {
        result = input1/input2;
    }
    //
    public void percent() {
        result = (input1/100) * input2;
    }
    // Tar roten ur på input1 bara
    public void squareRoot() {
        result = Math.sqrt(input2);
    }

    public void pythagoras() {
        result = Math.pow(input1,2) +Math.pow(input2,2);
    }
    //vi räknar med input1 som radie
    public void circleArea() {
        result =  Math.pow( input2,2) * Math.PI;
    }
    // vi räknar med input1 som radie och input 2 som höjd
    public void cylinderVolume() {
        result = Math.pow(input1, 2) * Math.PI * input2;
    }

}

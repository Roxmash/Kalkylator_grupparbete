package com.brandent.kalkylator_grupparbete;

public class CalcMath {

    private double input1;
    private double input2;

    public CalcMath(double input1, double input2){

        this.input1 = input1;
        this.input2 = input2;
    }

    public double addition() {
        return  input1 + input2;
    }

    public double subtraction() {
        return input1 - input2;
    }

    public double multiplication() {
        return input1 * input2;
    }

    public double division() {
        return  input1/input2;
    }
    //
    public double percent() {
        return (input1/100) * input2;
    }
    // Tar roten ur på input1 bara
    public double squareRoot() {
        return Math.sqrt(input2);
    }

    public double pythagoras() {
        return Math.pow(input1,2) +Math.pow(input2,2);
    }
    //vi räknar med input1 som radie
    public double circleArea() {
        return  Math.pow( input2,2) * Math.PI;
    }
    // vi räknar med input1 som radie och input 2 som höjd
    public double cylinderVolume() {
        return  Math.pow(input1, 2) * Math.PI * input2;
    }

}

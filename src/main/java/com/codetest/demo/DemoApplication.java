package com.codetest.demo;


public class DemoApplication {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Order order = calculator.getInput("bundle.txt");
        Bundle bundle = new Bundle();

        bundle.writeStringToTxt(order, calculator);


    }

}

package com.codetest.demo;


import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;


@Getter
@Setter
// This is the output class.
//  Order: An object, contains bundle format, bundles, and bundle prices.
public class Bundle {
    Order order = new Order();

    // Logger
    Logger logger = LoggerFactory.getLogger(getClass());



    //========================== Function 1 - Utility function ========================
    // Used in function "calBundle", store numbers you calculated.
    ArrayList<Integer> bundleNumberArray = new ArrayList<>();

    // subFunction
    //      input parameters like "14" and bundle array {10, 5}, calculate best bundles.
    // Main idea is division and get the remainder.
    //      For example, 14/10 = 1, remainder is 4. Then 4/5 = 0, remainder is 4.
    //      Then result should be 1x10; 1x5;
    public String calBundle(int inputNumber, int[] bundleArray) {
        int bundleRemainder = inputNumber;                                  // Bundle remainder, store remainder when calculate
        StringBuilder bundleOutputString = new StringBuilder();             // The output String

        if(bundleArray.length > 0){
            // calculate, store result in an array.
            for (int j : bundleArray) {                                     // Tips for Colin: Advanced For Loop. Quick fixed by Intellij.
                bundleNumberArray.add(bundleRemainder / j);                 //array.add(14/10)
                bundleRemainder = bundleRemainder % j;                      //remainder = 4;
            }
            // If remainder not 0, then should add the smallest bundle to bundle number array.
            if(bundleRemainder != 0){
                int lastNumber = bundleNumberArray.get(bundleNumberArray.size() - 1);
                bundleNumberArray.set(bundleNumberArray.size() - 1, lastNumber + 1);
            }
            // output the result in a String
            for (int i = 0; i < bundleNumberArray.size(); i++) {
                if(bundleNumberArray.get(i) != 0){
                    bundleOutputString.append(bundleNumberArray.get(i)).append(" x ").append(bundleArray[i]).append("; ");
                }
            }
        }else{
            bundleOutputString = new StringBuilder("Bundle Array is empty!");
        }

        return bundleOutputString.toString();
    }


    //========================== Function 2 - Utility function ========================
    // Utility function: IndexOf.
    // Return the index if the String is in a String[];
    public int indexOf(String[] format, String str){
        int index = -1;
        for (int i = 0; i < format.length; i++) {
            if(format[i].equals(str)){
                index = i;
                break;
            }
        }
        return index;
    }



    //========================== Function 3 - Main function ========================

    String[] format = order.getFormat();                //  {"IMG", "FLAC", "VID"}
    int[][] bundles = order.getBundles();               //  {{10,5}, {9,6,3}, {9,5,3}}
    double[][] prices = order.getPrices();              //  {{800,450}, {1147.50,810,427.50}, {1530,900,570}}

    // Main function
    // When user input Parameter like "14, IMG", output the best bundles.
    public String bestBundle(int number, String type) {
        int index = this.indexOf(format, type);
        String outputBundleString;      // Output String

        if(index != -1){
            if(number > 0){
                int[] bundle = bundles[index];
                outputBundleString = "Best bundle for '" + number + " " + type + "' is: " + calBundle(number, bundle);
            }else{
                outputBundleString = "Number should be bigger than 0!";
            }
        }else{
            outputBundleString = "Input type is not included in the format array!";
        }

        return outputBundleString;
    }


}

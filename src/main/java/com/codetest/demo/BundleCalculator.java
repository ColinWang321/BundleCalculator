package com.codetest.demo;


import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;


@Getter
@Setter
public class BundleCalculator {


    int[] imgBundleArray = {10, 5};
    int[] flacBundleArray = {9, 6, 3};
    int[] videoBundleArray = {9, 5, 3};

    // Used in function "calBundle", store numbers you calculated.
    ArrayList<Integer> bundleNumberArray = new ArrayList<>();

    Logger logger = LoggerFactory.getLogger(getClass());




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
                bundleNumberArray.add(bundleRemainder / j);        //array.add(14/10)
                bundleRemainder = bundleRemainder % j;             //remainder = 4;
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




    // Main function
    // When user input String like "14 IMG", output the best bundles.
    public String bestBundle(String input) {

        int inputNumber = 0;            // While split input string, this variable store number.
        String inputType = "";          // This variable store bundle type. Like "IMG" or "FLAC"

        String outputBundleString;      // Output String

        // 1. Split the string, get bundle number and bundle type.
        try {
            String[] array = input.split(" ");
            inputNumber = Integer.parseInt(array[0]);
            inputType = array[1];
        }catch(Exception e) {
            logger.error("Please input correct string, format should like this '10 IMG'! ");
//            System.out.println("Please input correct string, format should like this '10 IMG'! ");
        }

        // 2. Calculate best bundles.
        // 这里就可以用表驱动法。
        if(inputNumber > 0){
            switch (inputType.toUpperCase()){
                case "IMG":
                    outputBundleString = "Best bundle for '" + input + "' is: " + calBundle(inputNumber, imgBundleArray);
                    break;
                case "FLAC":
                    outputBundleString = "Best bundle for '" + input + "' is: " + calBundle(inputNumber, flacBundleArray);
                    break;
                case "VID":
                    outputBundleString = "Best bundle for '" + input + "' is: " + calBundle(inputNumber, videoBundleArray);
                    break;

                default:
                    outputBundleString = "Please input correct string, format should like this '10 IMG'!";
                    break;
            }
        }else{
            outputBundleString = "Number in string should be bigger than 0!";
        }

        return outputBundleString;
    }


}

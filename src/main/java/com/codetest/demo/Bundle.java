package com.codetest.demo;


import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


@Getter
@Setter
public class Bundle {
    Order order = new Order();
    Logger logger = LoggerFactory.getLogger(getClass());





    public String calBundle(int inputNumber, String type, int[] presetBundles, double[] presetPrices) {
        ArrayList<Integer> bundleNumberArray = new ArrayList<>();
        int bundleRemainderForCalculate = inputNumber;
        StringBuilder bundleOutputString = new StringBuilder();

        if(presetBundles.length > 0){
            for (int j : presetBundles) {
                bundleNumberArray.add(bundleRemainderForCalculate / j);
                bundleRemainderForCalculate = bundleRemainderForCalculate % j;
            }
            if(bundleRemainderForCalculate != 0){
                int lastNumber = bundleNumberArray.get(bundleNumberArray.size() - 1);
                bundleNumberArray.set(bundleNumberArray.size() - 1, lastNumber + 1);
            }
            int totalPrice = 0;
            StringBuilder lineString = new StringBuilder();
            for (int i = 0; i < bundleNumberArray.size(); i++) {
                if(bundleNumberArray.get(i) != 0){
                    int bundleNumber = bundleNumberArray.get(i);
                    double bundlePrice = presetPrices[i];
                    double linePrice = bundleNumber * bundlePrice;
                    totalPrice += linePrice;
                    lineString.append("| ").append(bundleNumber).append(" x ").append(presetBundles[i])
                            .append(" $").append(bundlePrice).append("\n");
                }
            }
            bundleOutputString.append(inputNumber).append(" ").append(type).append(" $").append(totalPrice).append("\n")
                    .append(lineString);
        }else{
            bundleOutputString = new StringBuilder("Bundle Array is empty!");
        }
        return bundleOutputString.toString();
    }



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





    public String singleBundle(int number, String type) {
        String[] format = order.getFormat();
        int[][] bundles = order.getBundles();
        double[][] prices = order.getPrices();
        int index = this.indexOf(format, type);
        String outputBundleString;

        if(index != -1){
            if(number > 0){
                int[] bundle = bundles[index];
                double[] price = prices[index];
//                outputBundleString = "Best bundle for '" + number + " " + type + "' is: " + calBundle(number, bundle);
                outputBundleString = calBundle(number, type, bundle, price);
            }else{
                outputBundleString = "Number should be bigger than 0!";
            }
        }else{
            outputBundleString = "Input type is not included in the format array! It should be 'IMG', 'FLAC', or 'VID'";
        }

        return outputBundleString;
    }



    public String calBestBundlesFromTxtFile(String filename){
        String message;
        ArrayList<Integer> numberStoreArray = new ArrayList<>();
        ArrayList<String> typeStoreArray = new ArrayList<>();
        try {
            File bundleFile = new File(filename);
            Scanner bundleReader = new Scanner(bundleFile);
            while(bundleReader.hasNextLine()){
                String data = bundleReader.nextLine();
                String[] singleLineElements = data.split(" ");
                numberStoreArray.add(Integer.parseInt(singleLineElements[0]));
                typeStoreArray.add(singleLineElements[1]);
            }

            FileWriter bundleWriter = new FileWriter("bundle result.txt");
            for (int i = 0; i < numberStoreArray.size(); i++) {
                bundleWriter.write(singleBundle(numberStoreArray.get(i), typeStoreArray.get(i)));
            }
            bundleWriter.close();
            singleBundle(numberStoreArray.get(0), typeStoreArray.get(0));

            message = "Calculate completed! Please check the 'bundle result.txt' in same directory!";
        }catch (FileNotFoundException e){
            logger.error("File Not Found!");
            message = "There's no such file named " + filename;
            e.printStackTrace();
        } catch (IOException e) {
            message = "Write file failed.";
            e.printStackTrace();
        }

        return message;
    }
}

package com.codetest.demo;


import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


@Getter
@Setter
public class Bundle {


    public void writeStringToTxt(Order order, Calculator calculator) {
        Logger logger = LoggerFactory.getLogger(getClass());
        BundleInfo bundleInfo = new BundleInfo();
        ArrayList<OrderItem> orderItems = order.getOrderItemArrayList();


        try {
            FileWriter bundleWriter = new FileWriter("bundle result.txt");
            for (OrderItem orderItem : orderItems) {
                ArrayList<Integer> bestBundles = calculator.bundleCalculator(orderItem, bundleInfo);
                String outputString = calculator.prepareSingleOrderItemString(bestBundles, orderItem, bundleInfo);

                bundleWriter.write(outputString);
            }
            bundleWriter.close();
            logger.info("Calculate completed! Please check the 'bundle result.txt' in same directory!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//
//
//    Logger logger = LoggerFactory.getLogger(getClass());
//
//    String CAL_COMPLETED = "Calculate completed! Please check the 'bundle result.txt' in same directory!";
//    String NO_SUCH_FILE = "There's no such file named ";
//    String WRITE_FILE_FAILED = "Write file failed.";
//
//    public int indexOf(String[] format, String str) {
//        int index = -1;
//        for (int i = 0; i < format.length; i++) {
//            if (format[i].equals(str)) {
//                index = i;
//                break;
//            }
//        }
//        return index;
//    }
//
//    public ArrayList<Integer> calBundle(int number, String type, Calculator order) {
//        ArrayList<Integer> calculatedNumbers = new ArrayList<>();
//        int bundleRemainderInCalculateProcess = number;
//
//        try {
//            int index = indexOf(order.getTypes(), type.toUpperCase());
//            int[] presetBundles = order.getBundles()[index];
//
//            if (presetBundles.length > 0) {
//                for (int j : presetBundles) {
//                    calculatedNumbers.add(bundleRemainderInCalculateProcess / j);
//                    bundleRemainderInCalculateProcess = bundleRemainderInCalculateProcess % j;
//                }
//                if (bundleRemainderInCalculateProcess != 0) {
//                    int lastNumber = calculatedNumbers.get(calculatedNumbers.size() - 1);
//                    calculatedNumbers.set(calculatedNumbers.size() - 1, lastNumber + 1);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return calculatedNumbers;
//    }
//
//
//    public String combineString(int number, String type, ArrayList<Integer> calculatedNumbers, Calculator order) {
//        int totalPrice = 0;
//        StringBuilder bundleString = new StringBuilder();
//        StringBuilder lineString = new StringBuilder();
//        int index = indexOf(order.getTypes(), type.toUpperCase());
//        int[] bundles = order.getBundles()[index];
//        double[] prices = order.getPrices()[index];
//
//
//        for (int i = 0; i < calculatedNumbers.size(); i++) {
//            if (calculatedNumbers.get(i) != 0) {
//                int numberInLine = calculatedNumbers.get(i);
//                double priceInLine = numberInLine * prices[i];
//                totalPrice += priceInLine;
//                lineString.append("| ").append(numberInLine).append(" x ").append(bundles[i])
//                        .append(" $").append(priceInLine).append("\n");
//            }
//        }
//        bundleString.append(number).append(" ").append(type).append(" $").append(totalPrice).append("\n")
//                .append(lineString);
//
//        return bundleString.toString();
//    }
//
//
//    public String calBestBundlesFromTxtFile(String filename) {
//        Calculator order = new Calculator();
//        String message;
//        ArrayList<Integer> numberStoreArray = new ArrayList<>();
//        ArrayList<String> typeStoreArray = new ArrayList<>();
//        try {
//            File bundleFile = new File(filename);
//            Scanner bundleReader = new Scanner(bundleFile);
//            while (bundleReader.hasNextLine()) {
//                String data = bundleReader.nextLine();
//                String[] singleLineElements = data.split(" ");
//                numberStoreArray.add(Integer.parseInt(singleLineElements[0]));
//                typeStoreArray.add(singleLineElements[1]);
//            }
//
//            FileWriter bundleWriter = new FileWriter("bundle result.txt");
//            for (int i = 0; i < numberStoreArray.size(); i++) {
//                int number = numberStoreArray.get(i);
//                String type = typeStoreArray.get(i);
//
//                ArrayList<Integer> calculatedNumbers = calBundle(number, type, order);
//                String singleBundleString = combineString(number, type, calculatedNumbers, order);
//                bundleWriter.write(singleBundleString);
//            }
//            bundleWriter.close();
//
//
//            message = this.CAL_COMPLETED;
//        } catch (FileNotFoundException e) {
//            message = this.NO_SUCH_FILE + filename;
//            e.printStackTrace();
//        } catch (IOException e) {
//            message = this.WRITE_FILE_FAILED;
//            e.printStackTrace();
//        }
//        return message;
//    }
}

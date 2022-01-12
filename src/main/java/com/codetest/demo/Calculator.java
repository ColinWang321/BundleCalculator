package com.codetest.demo;

import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


@Getter
public class Calculator {

    BundleInfo bundleInfo = new BundleInfo();

    public int indexOf(String[] format, String str) {
        int index = -1;
        for (int i = 0; i < format.length; i++) {
            if (format[i].equals(str)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public Order getInput(String filename) {
        Order order;
        ArrayList<OrderItem> orderItemsArrayList = new ArrayList<>();
        try {
            File inputFile = new File(filename);
            Scanner orderReader = new Scanner(inputFile);
            while (orderReader.hasNextLine()) {
                String data = orderReader.nextLine();
                int number = Integer.parseInt(data.split(" ")[0]);
                String type = data.split(" ")[1];

                OrderItem orderItem = new OrderItem(number, type);
                orderItemsArrayList.add(orderItem);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        order = new Order(orderItemsArrayList);
        return order;
    }


    public ArrayList<Integer> bundleCalculator(OrderItem orderItem, BundleInfo bundleInfo) {
        ArrayList<Integer> bestBundles = new ArrayList<>();
        int remainderNumber = orderItem.getNumber();

        try {
            int index = indexOf(bundleInfo.getTypes(), orderItem.getType().toUpperCase());
            int[] bundle = bundleInfo.getBundles()[index];

            if (bundle.length > 0) {
                for (int j : bundle) {
                    bestBundles.add(remainderNumber / j);
                    remainderNumber = remainderNumber % j;
                }
                if (remainderNumber != 0) {
                    int lastNumber = bestBundles.get(bestBundles.size() - 1);
                    bestBundles.set(bestBundles.size() - 1, lastNumber + 1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bestBundles;
    }

    public String prepareSingleOrderItemString(ArrayList<Integer> bestBundles, OrderItem orderItem, BundleInfo bundleInfo) {
        int totalPrice = 0;
        StringBuilder outputString = new StringBuilder();
        StringBuilder lineString = new StringBuilder();
        int index = indexOf(bundleInfo.getTypes(), orderItem.getType().toUpperCase());
        int[] bundles = bundleInfo.getBundles()[index];
        double[] prices = bundleInfo.getPrices()[index];


        for (int i = 0; i < bestBundles.size(); i++) {
            if (bestBundles.get(i) != 0) {
                int lineNumber = bestBundles.get(i);
                double lineTotalPrice = lineNumber * prices[i];
                totalPrice += lineTotalPrice;
                lineString.append("| ").append(lineNumber).append(" x ").append(bundles[i])
                        .append(" $").append(lineTotalPrice).append("\n");
            }
        }
        outputString.append(orderItem.getNumber()).append(" ").append(orderItem.getType()).append(" $").append(totalPrice).append("\n")
                .append(lineString);

        return outputString.toString();
    }




}

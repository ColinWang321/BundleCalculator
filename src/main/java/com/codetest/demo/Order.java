package com.codetest.demo;

import lombok.Getter;


@Getter
public class Order {

    String[] format = {"IMG", "FLAC", "VID"};
    int[][] bundles = {{10,5}, {9,6,3}, {9,5,3}};
    double[][] prices = {{800,450}, {1147.50,810,427.50}, {1530,900,570}};

}

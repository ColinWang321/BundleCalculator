package com.codetest.demo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItem {
    int number;
    String type;

    public OrderItem(int number, String type) {
        this.number = number;
        this.type = type;
    }
}

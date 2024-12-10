package org.example;

import org.example.task1.ATM;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ATM atm = new ATM();
        atm.getMeMoney(700);
    }
}
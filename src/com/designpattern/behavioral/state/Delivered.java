package com.designpattern.behavioral.state;

public class Delivered implements OrderState {
    @Override
    public double handleCancellation() {
        System.out.println("Contacting courier service for item pick-up");
        System.out.println("Contacting payment gateway for transaction roll-back");
        return 30;
    }
}

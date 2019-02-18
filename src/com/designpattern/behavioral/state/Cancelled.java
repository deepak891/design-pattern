package com.designpattern.behavioral.state;

public class Cancelled implements OrderState {
    @Override
    public double handleCancellation() {
        throw new IllegalStateException("Cancelled order, can't cancel again");
    }
}

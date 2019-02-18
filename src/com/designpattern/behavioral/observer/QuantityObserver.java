package com.designpattern.behavioral.observer;

public class QuantityObserver implements Observable {
    @Override
    public void updated(Order order) {
        if(order.getCount() > 5){
            order.setShippingCost(5);
        }
    }
}

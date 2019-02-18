package com.designpattern.behavioral.observer;

public class PriceObserver implements Observable {
    @Override
    public void updated(Order order) {
        if(order.getItemCost() > 500){
            order.setDiscount(20);
        } else if(order.getItemCost() > 200) {
            order.setDiscount(10);
        }
    }
}

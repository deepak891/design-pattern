package com.designpattern.behavioral.observer;

public class Client {
    public static void main(String[] args) {
        Order order = new Order("New#1");
        PriceObserver priceObserver = new PriceObserver();
        QuantityObserver quantityObserver = new QuantityObserver();
        order.attach(priceObserver);
        order.attach(quantityObserver);
        order.addItem(50);
        order.addItem(500);
        order.addItem(10);
        order.addItem(40);
        order.addItem(30);
        order.addItem(10);
        System.out.println(order);
    }
}

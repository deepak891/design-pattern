package com.designpattern.behavioral.state;

public class Client {
    public static void main(String[] args) {
        Order order = new Order();
        order.paymentSuccessful();
        order.delivered();
        order.dispatched();

        order.cancel();
    }
}

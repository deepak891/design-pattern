package com.designpattern.behavioral.state;

public class InTransit implements OrderState {
    @Override
    public double handleCancellation() {
        System.out.println("Contacting courier service for cancellation");
        System.out.println("Contacting payment gateway for transaction rollback ");
        return 20;
    }

    //This another way of implementing transaction from one state to another state.
    public OrderState next(){
        return new Delivered();
    }
}

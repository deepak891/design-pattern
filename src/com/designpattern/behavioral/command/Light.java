package com.designpattern.behavioral.command;

//Receiver
public class Light {

    public void turnOn() {
        System.out.println("Light is on ...");
    }

    public void turnOff() {
        System.out.println("Light is off ...");
    }
}

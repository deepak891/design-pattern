package com.designpattern.structural.facade.email;

public class StationaryFactory {
    public static Stationary createStationary(){
        return new HalloweenStationary();
    }
}

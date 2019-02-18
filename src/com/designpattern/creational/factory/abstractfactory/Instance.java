package com.designpattern.creational.factory.abstractfactory;

//Represent abstract product
public interface Instance {
    public static enum Capacity {micro, small, large}

    void start();

    void attachStorage(Storage storage);

    void stop();
}

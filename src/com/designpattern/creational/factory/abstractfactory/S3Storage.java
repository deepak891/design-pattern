package com.designpattern.creational.factory.abstractfactory;

//Represent a concrete product in family, AWS
public class S3Storage implements Storage {

    public S3Storage(int capacityInMib) {
        System.out.println("Allocated " + capacityInMib + " on S3");
    }

    @Override
    public String getId() {
        return "S3_1";
    }

    @Override
    public String toString() {
        return "S3Storage{}";
    }
}

package com.designpattern.creational.factory.abstractfactory;

//Represent a concrete product in a family "GCP"
public class GoogleCloudStorage implements Storage {

    public GoogleCloudStorage(int capacityInMib) {
        //Use GCP api
        System.out.println("Allocate " + capacityInMib + " on GCP");
    }

    @Override
    public String getId() {
        return "GCP_CS1";
    }

    @Override
    public String toString() {
        return "GoogleCloudStorage{}";
    }
}

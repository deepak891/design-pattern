package com.designpattern.creational.factory.abstractfactory;

//Represent a concrete product in a family "GCP"
public class GoogleComputeEngineInstance implements Instance {

    public GoogleComputeEngineInstance(Capacity capacity) {
        //Map capacity to GCP compute instance type. Use GCP API to provision.
        System.out.println("Create Google Compute Engine instance");
    }

    @Override
    public void start() {
        System.out.println("Compute engine instance started");
    }

    @Override
    public void attachStorage(Storage storage) {
        System.out.println("Attach " + storage + "to compute engine instance ");
    }

    @Override
    public void stop() {
        System.out.println("Compute engine instance stopped");
    }
}

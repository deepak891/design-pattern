package com.designpattern.creational.factory.abstractfactory;

/**
 *
 *  - When ever we have multiple set of objects where object in one set work together then
 *     you can use abstract factory pattern to isolate client code from concrete objects & their factories
 *  - Abstract Factory make use of factory method design pattern. Abstract factory is an object with multiple factories
 *  - Adding a new product type needs changes to base factory and all its implementations.
 *  - Concrete factories can be singleton as we need only one instance of them in code, typically they don't have any state into them
 *  - We provide client code with concrete factory instance. Factories can be changed at run time.
 */
public class Main {

    private ResourceFactory resourceFactory;

    public Main(ResourceFactory resourceFactory) {
        this.resourceFactory = resourceFactory;
    }

    public Instance createServer(Instance.Capacity cap, int storageMib) {
        Instance instance = resourceFactory.createInstance(cap);
        Storage storage = resourceFactory.createStorage(storageMib);
        instance.attachStorage(storage);
        return instance;
    }
    public static void main(String[] args) {
        Main aws = new Main(new AwsResourceFactory());
        Instance i1 = aws.createServer(Instance.Capacity.micro, 204800);
        i1.start();
        i1.stop();

        System.out.println("**********************************");

        Main google = new Main(new GoogleResourceFactory());
        Instance i2 = google.createServer(Instance.Capacity.large, 204800);
        i2.start();
        i2.stop();

    }
}

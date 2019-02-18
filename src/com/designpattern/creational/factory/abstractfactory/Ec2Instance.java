package com.designpattern.creational.factory.abstractfactory;

//Represent a concrete product in a family AWS
public class Ec2Instance implements Instance {

    public Ec2Instance(Capacity capacity) {
        //Map capacity to ec2 instance typs. Use AWS API to provision.
        System.out.println("Create Ec2Instance");
    }

    @Override
    public void start() {
        System.out.println("Create Ec2 Instance");
    }

    @Override
    public void attachStorage(Storage storage) {
        System.out.println("Attached " + storage + " to Ec2Instance");
    }

    @Override
    public void stop() {
        System.out.println("Ec2Instance Stopped");
    }

    @Override
    public String toString() {
        return "Ec2Instance{}";
    }
}

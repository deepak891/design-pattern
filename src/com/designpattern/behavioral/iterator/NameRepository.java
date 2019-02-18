package com.designpattern.behavioral.iterator;

public class NameRepository {

    private String[] names = {"Adam","Joe","John","Sara"};

    public Iterator getIterator(){
        return new NameIterator(names);
    }
}

package com.designpattern.structural.bridge;

//This is the abstraction.
//This represent first in first out
public interface FifoCollection<T> {

    //Adds element to collection
    void offer(T element);

    //Remove & return first element from collection
    T poll();
}

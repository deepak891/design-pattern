package com.designpattern.creational.objectpool;

//Interface defining reset operation and it can be used with any type to use it with pool
public interface Poolable {

    //state reset
    void reset();
}

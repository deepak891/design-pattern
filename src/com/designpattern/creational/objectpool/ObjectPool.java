package com.designpattern.creational.objectpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.Supplier;

//Here we are pre-creating all objects
public class ObjectPool<T extends Poolable> {

    private BlockingQueue<T> availablePool;

    public ObjectPool(Supplier<T> creator, int count){
        availablePool = new LinkedBlockingDeque<>();
        for(int i = 0 ; i < count ; i++) {
            availablePool.offer(creator.get());
        }
    }

    //Get method must decide what to do if pool is empty. It can create new
    //object and return that or wait until one become available
    public T get(){
        try {
            return availablePool.take();
        }catch (InterruptedException e) {
            System.err.println("take() was interrupted");
        }
        return null;
    }

    public void release(T obj){
        obj.reset();
        try {
            availablePool.put(obj);
        } catch (InterruptedException e) {
            System.err.println("take() was interrupted");
        }
    }

}

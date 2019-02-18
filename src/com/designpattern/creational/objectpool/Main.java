package com.designpattern.creational.objectpool;

import javafx.geometry.Point2D;

/**
 * What is object Pool?
 * - In our system cost of creating an instance of a class is high and we need a large number of
 *   objects of this class for short duration, then we can use object pool.
 * - Here we either create a pre-create an object of this class or collect unused instance in an in memory cache.
 *
 * Design consideration
 *  - Object pool can be parameterized to chache & return multiple objects and the acquire method can provide selection criteria
 */
public class Main {

    //Create the pool of 5 objects
    public static final ObjectPool<Bitmap> bitmapPool = new ObjectPool<>(()-> new Bitmap("Image.png"), 5);

    public static void main(String[] args) {
        //get objects from pool and use as regular object
        Bitmap b1 = bitmapPool.get();
        b1.setLocation(new Point2D(10,10));
        Bitmap b2 = bitmapPool.get();
        b2.setLocation(new Point2D(-10, 10));
        b1.draw();
        b2.draw();

        //release object
        bitmapPool.release(b1);
        bitmapPool.release(b2);
    }
}

package com.designpattern.structural.proxy;

//Factory gets image object
public class ImageFactory {
    //We'll provide proxy to caller instead of real object

    public static Image getImage(String fileName) {
        return new ImageProxy(fileName);
    }
}

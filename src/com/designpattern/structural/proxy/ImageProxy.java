package com.designpattern.structural.proxy;

import javafx.geometry.Point2D;

//Proxy class
public class ImageProxy implements Image{

    private String fileName;
    private BitmapImage image;
    private Point2D location;

    public ImageProxy(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public Point2D getLocation() {
        if(image != null) {
            image.getLocation();
        }
        return location;
    }

    @Override
    public void setLocation(Point2D point2D) {
        if(image != null) {
            image.setLocation(point2D);
        }else {
            location = point2D;
        }
    }

    @Override
    public void render() {
        if(image == null) {
            image = new BitmapImage(fileName);
            if(location != null) {
                image.setLocation(location);
            }
        }
        image.render();
    }
}

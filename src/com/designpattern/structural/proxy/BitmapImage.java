package com.designpattern.structural.proxy;

import javafx.geometry.Point2D;

public class BitmapImage implements Image {
    private Point2D location;
    private String name;

    public BitmapImage(String fileName) {
        //Load image from disk
        System.out.println("Loaded from disk" + fileName);
        this.name = fileName;
    }

    @Override
    public Point2D getLocation() {
        return location;
    }

    @Override
    public void setLocation(Point2D point2D) {
        location = point2D;
    }

    @Override
    public void render() {
        //Render on screen
        System.out.println("Rendered " + this.name);
    }
}

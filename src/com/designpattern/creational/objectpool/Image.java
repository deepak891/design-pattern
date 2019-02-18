package com.designpattern.creational.objectpool;

import javafx.geometry.Point2D;

//Represent our abstract resuable
public interface Image extends Poolable{

    void draw();

    Point2D getLocation();

    void setLocation(Point2D location);
}

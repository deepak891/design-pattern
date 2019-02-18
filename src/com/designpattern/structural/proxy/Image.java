package com.designpattern.structural.proxy;

import javafx.geometry.Point2D;

//Interface implemented by proxy and concrete class
public interface Image {

    Point2D getLocation();

    void setLocation(Point2D point2D);

    void render();
}

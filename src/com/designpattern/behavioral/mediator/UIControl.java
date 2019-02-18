package com.designpattern.behavioral.mediator;

//Abstract Colleague
public interface UIControl {

    void controlChanged(UIControl control);

    String getControlValue();

    String getControlName();
}

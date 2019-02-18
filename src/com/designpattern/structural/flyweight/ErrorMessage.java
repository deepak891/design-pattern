package com.designpattern.structural.flyweight;

//Interface implemented by flyweight
public interface ErrorMessage {

    //Get error message this is the extrinsic state which is provided by client
    String getText(String code);
}

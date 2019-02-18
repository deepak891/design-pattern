package com.designpattern.structural.decorator;

//Concrete component. Object to be decorated
public class TexMessage implements Message {

    private String msg;

    public TexMessage(String msg) {
        this.msg = msg;
    }

    @Override
    public String getContent() {
        return this.msg;
    }
}

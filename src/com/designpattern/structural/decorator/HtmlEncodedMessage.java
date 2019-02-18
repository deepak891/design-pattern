package com.designpattern.structural.decorator;

//Decorator. Implements component interface
public class HtmlEncodedMessage implements Message{

    private Message msg;

    public HtmlEncodedMessage(Message msg) {
        this.msg = msg;
    }

    @Override
    public String getContent() {
        return new String("Html Encoded Message " + msg.getContent());
    }
}

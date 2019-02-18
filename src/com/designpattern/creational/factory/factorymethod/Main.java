package com.designpattern.creational.factory.factorymethod;

/**
 * What is factory method?
 *      - We want to move our object creation logic to separate class.
 *      - We use this pattern when we do not know in advance which class we
 *         may need to instantiate beforehand & also to allow new classes to the
 *         system without affecting client code.
 *      - We let subclasses decide which object to instantiate by overriding factory method.
 *
 *              Product                                      Creator
 *             /        \                                   /          \
 *    ConcreteProductB  ConcreteProductA    <----- ConcreteCreatorA    ConcreteCreatorB
 *          \                                                                  /
 *            -----------------------------------------------------------------
 */
public class Main {
    public static void main(String[] args) {
        printMessage(new JsonMessageCreator());

        printMessage(new TextMessageCreator());
    }

    public static void printMessage(MessageCreator creator) {
        Message msg = creator.getMessage();
        System.out.println(msg.getContent());
    }
}

class TextMessageCreator extends MessageCreator{

    @Override
    public Message createMessage() {
        return new TextMessage();
    }
}

class JsonMessageCreator extends MessageCreator {

    @Override
    public Message createMessage() {
        return new JsonMessage();
    }
}

abstract class MessageCreator{
    //This is abstract creator
    public Message getMessage() {
        Message msg = createMessage();

        //Performs additional step which is not in simple factory
        msg.addDefaultHeader();
        msg.encrypt();
        return msg;
    }
    public abstract Message createMessage();
}

class TextMessage extends Message{

    @Override
    public String getContent() {
        return "Text";
    }
}

class JsonMessage extends Message {
    @Override
    public String getContent() {
        return "{\" JSON \":[]}";
    }
}

abstract class Message {
    public abstract String getContent();
    public void addDefaultHeader(){
        //some code to add default header
    }

    public void encrypt() {
        //some code to encrypt message
    }
}

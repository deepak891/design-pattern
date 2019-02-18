package com.designpattern.structural.decorator;

/**
 * Decorator design pattern:
 *      - When we want to enhance behaviour of existing object dynamically as and when required.
 *      - Decorator wraps an object within itself and provide same interface so the client of original object don't need to change.
 *      - A decorator provide alternative to subclassing for extending functionality of existing classes.
 *      - Since we have decorators and concrete class extending from common component avoid large number of state in base as decorators may not need those state.
 *      - Pay attention to hashcode and equal methods of decorators. When using decorator you have to decide if decorator object are same as base object.
 */
public class Client {
    public static void main(String[] args) {
        Message m = new TexMessage("The <Force> is strong with this one");
        System.out.println(m.getContent());

        Message decorator = new HtmlEncodedMessage(m);
        System.out.println(decorator.getContent());

        decorator = new Base64EncodedMessage(decorator);
        System.out.println(decorator.getContent());
    }
}

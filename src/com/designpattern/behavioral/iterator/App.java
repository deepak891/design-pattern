package com.designpattern.behavioral.iterator;

/**
 * Iterator pattern is very commonly used design pattern!!
 * This is used to get a way to access elements of object in sequential manner without any
 * need to know its underlying representation.
 */
public class App {
    public static void main(String[] args) {
        NameRepository repository = new NameRepository();
        for(Iterator itr = repository.getIterator() ; itr.hasNext() ; ) {
            String name = (String) itr.next();
            System.out.println(name);
        }
    }
}

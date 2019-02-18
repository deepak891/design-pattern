package com.designpattern.creational.builder;


/**
 * Why prefer builder?
 *
 * There will be lot of parameter in the constructor - hard of follow,
 * setter are the same not bet solution
 *
 * - not extensible when we have to add new parameter, we have to create one more constructor.
 *      - with builder we just add another method.
 * - immutable property :
 */
public class Apps {
    public static void main(String[] args) {
        Person person = new Person.Builder("Deepak","deepak891@gmail.com").setAge(36).setAddress("Singapore").build();
        System.out.println(person);
    }
}

package com.designpattern.structural.bridge;

//This is the implementor
//Note this is also an interface
// As implementor is defining it own hierarchy which is not related. at all the the abstraction hierarchy
public interface LinkedList<T> {

    void addFirst(T element);

    T removeFirst();

    void addLast(T element);

    T removeLast();

    int getSize();

}

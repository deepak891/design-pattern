package com.designpattern.behavioral.iterator2;

public class Client {
    public static void main(String[] args) {
        Iterator itr = ThemeColor.getIterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}

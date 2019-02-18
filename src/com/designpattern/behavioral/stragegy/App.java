package com.designpattern.behavioral.stragegy;

public class App {
    public static void main(String[] args) {
       SortManager sortManager = new SortManager();
       sortManager.sort(new QuickSort());
    }
}

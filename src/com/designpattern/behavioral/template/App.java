package com.designpattern.behavioral.template;

/**
 *  In template pattern a abstract class expose a defined way / template to execute its method
 *  Its subclass can override method implementation as per the need but method invocation should
 *  be as per abstract method
 *
 */
public class App {
    public static void main(String[] args) {
        int[] numbers = {2,4,-5,7,1};
        Algorithm algorithm = new InsertionSort(numbers);
        algorithm.sort();
    }
}

package com.designpattern.creational.factory;

/**
 * Factory Pattern helps create loosely coupled OO design !!
 *
 * WHAT IS PROBLEM WITH THE NEW KEY WORD?
 *
 * We should not program to implementation, we should program to an interface.
 * -tying out code to a concrete class: make our application more fragile and less flexible
 *
 * We should find the part of code that will change -> separate it
 * We may encapsulate object creation
 */
public class Apps {
    public static void main(String[] args) {
        Algorithm algorithm = AlgorithmFactory.createAlgorithm(AlgorithmFactory.Path.SPANNING);
        algorithm.solve();
    }
}

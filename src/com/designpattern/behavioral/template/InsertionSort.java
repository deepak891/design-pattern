package com.designpattern.behavioral.template;

public class InsertionSort extends Algorithm {

    private int[] numbers;

    public InsertionSort(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void initialize() {
        System.out.println("Initializing");
    }

    @Override
    public void sorting() {

    }

    @Override
    public void printResult() {
        for(int i = 0 ; i < numbers.length ; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}

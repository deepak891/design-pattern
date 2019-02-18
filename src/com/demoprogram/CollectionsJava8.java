package com.demoprogram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionsJava8 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A","B","C","D");
        List<Integer> listOfInt = list.stream().map(String::length).collect(Collectors.toList());
        System.out.println(listOfInt);

        List<String> list1 = Arrays.asList("A","B","C","D");
        List<String> newList = new ArrayList<>();
        newList.addAll(list);
        newList.addAll(list1);

        System.out.println(newList.stream().map(String::length).collect(Collectors.toList()));

        System.out.println(Stream.of(list, list1).flatMap(List::stream ).collect(Collectors.toList()));


    }
}

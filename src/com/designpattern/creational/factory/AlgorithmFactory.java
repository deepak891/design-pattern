package com.designpattern.creational.factory;

public class AlgorithmFactory {

    enum Path{
        SHORTEST, SPANNING;
    }

    public static Algorithm createAlgorithm(Path type) {
        switch (type) {
            case SHORTEST:
                return new ShortestPath();
            case SPANNING:
                return new SpanningTree();
            default:
                return null;
        }
    }

}

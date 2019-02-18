package com.designpattern.behavioral.iterator;

public class NameIterator implements Iterator {

    private String[] names;
    private int index;

    public NameIterator(String[] names) {
        this.names = names;
    }

    @Override
    public boolean hasNext() {
        return names.length > index;
    }

    @Override
    public Object next() {
        if(hasNext())
            return names[index++];
        return null;
    }
}

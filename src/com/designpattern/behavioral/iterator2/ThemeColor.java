package com.designpattern.behavioral.iterator2;

public enum ThemeColor {
    RED,
    ORANGE,
    GREEN,
    BLACK;

    public static Iterator<ThemeColor> getIterator(){
       return new ThemeColorIterator();
    }

    private static class ThemeColorIterator implements Iterator<ThemeColor>{
        private int position;
        @Override
        public boolean hasNext() {
            return  position < ThemeColor.values().length;
        }

        @Override
        public ThemeColor next() {
            return ThemeColor.values()[position++];
        }
    }
}

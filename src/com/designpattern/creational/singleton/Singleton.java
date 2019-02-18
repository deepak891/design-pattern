package com.designpattern.creational.singleton;

public class Singleton {

    public static void main(String[] args) {
        Eager instance = Eager.getInstance();
        Eager instance1 = Eager.getInstance();
        System.out.println(instance == instance1);

        Lazy lazy1 = Lazy.getInstance();
        Lazy lazy2 = Lazy.getInstance();
        System.out.println(lazy1 == lazy2);

        LazyIODH singleton = LazyIODH.getInstance();
        singleton = LazyIODH.getInstance();
        singleton = LazyIODH.getInstance();

        System.out.println("Done");

        RegistryEnum obj = RegistryEnum.INSTANCE;
        obj.getConfiguration();
    }
}


class Eager {
    private Eager() {
    }

    private static Eager INSTANCE = new Eager();

    public static Eager getInstance(){
        return INSTANCE;
    }

}

//Double locking
class Lazy {
    private Lazy(){}

    private static volatile Lazy INSTANCE ;

    public static Lazy getInstance() {
        if(INSTANCE == null) {
            synchronized (Lazy.class) {
                if(INSTANCE == null) {
                    INSTANCE = new Lazy();
                }
            }
        }
        return INSTANCE;
    }
}

class LazyIODH {
    private LazyIODH(){
        System.out.println("In LazyIODH singletone");
    }
    private static class Holder {
        static LazyIODH lazyIODH = new LazyIODH();
    }

    public static LazyIODH getInstance() {
        return Holder.lazyIODH;
    }
}

enum  RegistryEnum {

    INSTANCE;

    public void getConfiguration() {
        System.out.println("Enum singleton");
    }
}
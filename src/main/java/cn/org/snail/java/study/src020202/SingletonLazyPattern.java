package cn.org.snail.java.study.src020202;

public class SingletonLazyPattern {
    private static SingletonLazyPattern INSTANCE;

    public static SingletonLazyPattern getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonLazyPattern();
        }
        return INSTANCE;
    }

    private SingletonLazyPattern() {
        if (INSTANCE != null) {
            throw new RuntimeException("cannot create instance");
        }
    }
    public SingletonLazyPattern readResolve(){
        return this;
    }
}

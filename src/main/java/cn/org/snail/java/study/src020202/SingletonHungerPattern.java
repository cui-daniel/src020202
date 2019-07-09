package cn.org.snail.java.study.src020202;

public class SingletonHungerPattern {
    private static final SingletonHungerPattern INSTANCE=new SingletonHungerPattern();

    public static SingletonHungerPattern getInstance() {
        return INSTANCE;
    }

    private SingletonHungerPattern() {
        if (INSTANCE != null) {
            throw new RuntimeException("cannot create instance");
        }
    }
    public SingletonHungerPattern readResolve(){
        return this;
    }
}

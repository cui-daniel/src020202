package cn.org.snail.java.study.src020202;

public class SingletonDoubleCheckLazyPattern {
    private static SingletonDoubleCheckLazyPattern INSTANCE;

    public static SingletonDoubleCheckLazyPattern getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonDoubleCheckLazyPattern.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonDoubleCheckLazyPattern();
                }
            }
        }
        return INSTANCE;
    }

    private SingletonDoubleCheckLazyPattern() {
        if (INSTANCE != null) {
            throw new RuntimeException("cannot create instance");
        }
    }
    public SingletonDoubleCheckLazyPattern readResolve(){
        return this;
    }
}

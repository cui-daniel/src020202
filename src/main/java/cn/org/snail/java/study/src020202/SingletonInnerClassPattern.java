package cn.org.snail.java.study.src020202;

public class SingletonInnerClassPattern {
    private static class InnerClass {
        private static SingletonInnerClassPattern INSTANCE = new SingletonInnerClassPattern();
    }


    public static SingletonInnerClassPattern getInstance() {
        return InnerClass.INSTANCE;
    }

    private SingletonInnerClassPattern() {
        if (getInstance() != null) {
            throw new RuntimeException("cannot create instance");
        }
    }

    public SingletonInnerClassPattern readResolve() {
        return this;
    }
}

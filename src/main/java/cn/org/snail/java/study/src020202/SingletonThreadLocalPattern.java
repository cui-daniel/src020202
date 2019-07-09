package cn.org.snail.java.study.src020202;

public class SingletonThreadLocalPattern {
    private static final ThreadLocal<SingletonThreadLocalPattern> INSTANCE = new ThreadLocal<SingletonThreadLocalPattern>(){
        @Override
        protected SingletonThreadLocalPattern initialValue() {
            return new SingletonThreadLocalPattern();
        }
    };

    public static SingletonThreadLocalPattern getInstance() {
        return INSTANCE.get();
    }

}

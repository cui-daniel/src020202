package cn.org.snail.java.study.src020202;

import java.util.concurrent.ConcurrentHashMap;

public class SingletonRegisterPattern {
    private static final ConcurrentHashMap<Class<?>, Object> INSTANCE = new ConcurrentHashMap<>();

    public static Object getInstance(Class<?> clazz) {
        Object object = INSTANCE.get(clazz);
        if (object == null) {
            synchronized (INSTANCE) {
                object = INSTANCE.get(clazz);
                if (object == null) {
                    try {
                        object = clazz.newInstance();
                        INSTANCE.put(clazz, object);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return object;
    }
}

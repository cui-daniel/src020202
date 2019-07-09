package cn.org.snail.java.study.src020202;

public enum SingletonEnumPattern {
    INSTANCE(new Object());
    private final Object value;

    private SingletonEnumPattern(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}

package com.will.asgard.loki.model.generic;

/**
 * @Description rt
 * @Author zjumlw
 * @Date 2020-10-19 9:27 下午
 * @Version 1.0
 */
class Pair<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

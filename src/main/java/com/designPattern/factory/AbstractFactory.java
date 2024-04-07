package com.designPattern.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractFactory<E extends Enum<E>, Instance> {

    private final Map<E, Instance> map = new ConcurrentHashMap<>();
    public AbstractFactory(Class<E> e) {
        for (E constant : e.getEnumConstants()) {
            map.put(constant, createInstance(constant));
        }
    }

    public Instance getInstance(E e){
        return map.get(e);
    }

    public abstract Instance createInstance(E e);
}

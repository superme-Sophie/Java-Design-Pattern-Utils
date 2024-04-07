package com.designPattern.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractMultitonManager<E extends Enum<E>, Multiton extends SingletonInterface>{

    public AbstractMultitonManager(SingletonEnums type, Class<E> enums) {
        if (type == SingletonEnums.PRE_LOAD) {
            for (E constant : enums.getEnumConstants()) {
                manager.put(constant, createBean(constant));
            }
        }
    }

    private final Map<E, Multiton> manager = new ConcurrentHashMap<>();

    public Multiton getBean(E e) {
        if (manager.containsKey(e) && !manager.get(e).isLoseEffectiveness()) {
            return manager.get(e);
        }
        Multiton bean = createBean(e);
        manager.put(e, bean);
        return bean;
    }

    public abstract Multiton createBean(E e);
}

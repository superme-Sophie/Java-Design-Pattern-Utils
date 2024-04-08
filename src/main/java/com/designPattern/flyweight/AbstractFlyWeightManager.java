package com.designPattern.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractFlyWeightManager<E extends Enum<E>, Entity extends FlyWeight> {

    private final Map<E, Entity> manager = new ConcurrentHashMap<>();

    protected AbstractFlyWeightManager<E, Entity> insert(E type, Entity entity) {
        manager.put(type, entity);
        return this;
    }

    public Entity get(E e) {
        return manager.get(e);
    }

}

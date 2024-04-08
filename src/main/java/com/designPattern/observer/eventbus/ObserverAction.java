package com.designPattern.observer.eventbus;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class ObserverAction {
    private final Object target;
    private final Method method;

    public ObserverAction(Object target, Method method) {
        if (target == null) {
            throw new NullPointerException();
        }
        this.target = target;
        this.method = method;
        this.method.setAccessible(true);
    }

    public void execute(Object event) {
        try {
            method.invoke(target, event);
        } catch (InvocationTargetException | IllegalAccessException e) {
            log.error("event bus invoke event fail", e);
        }
    }
}

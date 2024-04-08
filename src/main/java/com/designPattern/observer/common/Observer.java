package com.designPattern.observer.common;

public interface Observer<M extends Message> {

    void notify(M m);
}

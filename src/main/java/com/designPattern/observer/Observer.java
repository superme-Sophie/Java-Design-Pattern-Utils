package com.designPattern.observer;

public interface Observer<M extends Message> {

    void notify(M m);
}

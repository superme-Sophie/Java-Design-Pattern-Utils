package com.designPattern.observer;

public interface Observers<M extends Message> {

    void notify(M m);
}

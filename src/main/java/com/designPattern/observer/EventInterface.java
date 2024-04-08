package com.designPattern.observer;

public interface EventInterface<M extends Message> {

    void registerObserver(Observers<M> e);
    void removeObserver(Observers<M> e);
    void notifyObserver(M m);
}

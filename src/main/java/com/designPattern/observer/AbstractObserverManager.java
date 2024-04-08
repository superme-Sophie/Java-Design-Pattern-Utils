package com.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class AbstractObserverManager<M extends Message> {
    protected final List<Observer<M>> observers = new ArrayList<>();

    public void registerObserver(Observer<M> e) {
        observers.add(e);
    }

    public void removeObserver(Observer<M> e) {
        observers.remove(e);
    }

    public void notifyObserver(M m) {
        for (Observer<M> e : observers) {
            e.notify(m);
        }
    }
}

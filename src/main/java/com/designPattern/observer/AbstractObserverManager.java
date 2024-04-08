package com.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class AbstractObserverManager<M extends Message> implements EventInterface<M> {
    private final List<Observers<M>> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observers<M> e) {
        observers.add(e);
    }

    @Override
    public void removeObserver(Observers<M> e) {
        observers.remove(e);
    }

    @Override
    public void notifyObserver(M m) {
        for (Observers<M> e : observers) {
            e.notify(m);
        }
    }
}

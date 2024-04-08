package com.designPattern.observer.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AbstractObserverKeyManager<M extends Message, E extends Enum<E>> {

    private final Map<E, List<Observer<M>>> map = new ConcurrentHashMap<>();

    public void registerObserver(E key, Observer<M> e) {
        if (map.containsKey(key)) {
            List<Observer<M>> observers = map.get(key);
            observers.add(e);
        } else {
            ArrayList<Observer<M>> observers = new ArrayList<>();
            map.put(key, observers);
            observers.add(e);
        }
    }

    public void removeObserver(E key, Observer<M> e) {
        if (map.containsKey(key)) {
            map.get(key).remove(e);
        }
    }

    public void notifyObserver(E key, M m) {
        if (map.containsKey(key)) {
            for (Observer<M> observer : map.get(key)) {
                observer.notify(m);
            }
        }
    }


}

package com.designPattern.observer;

public class ObserverManager extends AbstractObserverManager<DefaultMessage> {

    public ObserverManager() {
        registerObserver(new Ob1());
        registerObserver(new Ob1());
        registerObserver(new Ob2());
    }

}

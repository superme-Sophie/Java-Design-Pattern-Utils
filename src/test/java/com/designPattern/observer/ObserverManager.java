package com.designPattern.observer;

import org.junit.jupiter.api.Test;

public class ObserverManager extends AbstractObserverManager<DefaultMessage> {

    public ObserverManager() {
        registerObserver(new Ob1());
        registerObserver(new Ob1());
        registerObserver(new Ob2());
    }

}

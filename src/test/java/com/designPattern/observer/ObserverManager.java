package com.designPattern.observer;

import com.designPattern.observer.common.AbstractObserverManager;
import com.designPattern.observer.common.DefaultMessage;
import com.designPattern.observer.common.Ob1;
import com.designPattern.observer.common.Ob2;

public class ObserverManager extends AbstractObserverManager<DefaultMessage> {

    public ObserverManager() {
        registerObserver(new Ob1());
        registerObserver(new Ob1());
        registerObserver(new Ob2());
    }

}

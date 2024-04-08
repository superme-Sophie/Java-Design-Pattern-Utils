package com.designPattern.observer;

import com.designPattern.observer.common.*;

public class OBKEYManger extends AbstractObserverKeyManager<DefaultMessage, ObEnums> {

    public OBKEYManger() {
        registerObserver(ObEnums.O1, new Ob1());
        registerObserver(ObEnums.O2, new Ob2());
    }
}

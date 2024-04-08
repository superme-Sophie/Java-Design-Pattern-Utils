package com.designPattern.observer;

import org.junit.jupiter.api.Test;

public class ObserverTest {

    @Test
    public void test(){
        ObserverManager manager = new ObserverManager();
        manager.notifyObserver(new DefaultMessage("QQQ"));

        OBKEYManger manger = new OBKEYManger();
        manger.notifyObserver(ObEnums.O1, new DefaultMessage("TTT"));
    }
}

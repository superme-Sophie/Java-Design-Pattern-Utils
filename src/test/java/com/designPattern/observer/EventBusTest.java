package com.designPattern.observer;

import com.designPattern.observer.common.DefaultMessage;
import com.designPattern.observer.common.Ob1;
import com.designPattern.observer.common.Ob2;
import com.designPattern.observer.eventbus.AsyncEventBus;
import com.designPattern.observer.eventbus.EventBus;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;

public class EventBusTest {

    private static final EventBus eventBus = new EventBus();
    private static final AsyncEventBus asyncEventBus = new AsyncEventBus(Executors.newFixedThreadPool(20));

    static {
        eventBus.register(new Ob1());
        eventBus.register(new Ob2());
        asyncEventBus.register(new Ob1());
        asyncEventBus.register(new Ob2());
    }

    @Test
    public void test(){
        eventBus.post(new DefaultMessage("QQQ"));
        asyncEventBus.post(new DefaultMessage("TTT"));
    }
}

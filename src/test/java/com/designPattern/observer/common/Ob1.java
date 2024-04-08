package com.designPattern.observer.common;

import com.designPattern.observer.eventbus.Subscribe;

public class Ob1 implements Observer<DefaultMessage> {
    @Override
    @Subscribe
    public void notify(DefaultMessage defaultMessage) {
        System.out.println("ob1" + defaultMessage.getData());
    }
}

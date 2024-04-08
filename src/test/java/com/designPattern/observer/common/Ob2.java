package com.designPattern.observer.common;

import com.designPattern.observer.eventbus.Subscribe;

public class Ob2 implements Observer<DefaultMessage> {
    @Override
    @Subscribe
    public void notify(DefaultMessage defaultMessage) {
        System.out.println("ob2" + defaultMessage.getData());
    }
}
